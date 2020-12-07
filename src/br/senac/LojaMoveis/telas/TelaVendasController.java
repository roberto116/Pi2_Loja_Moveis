/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.Produto;
import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import br.senac.LojaMoveis.bd.ClienteDAO;
import br.senac.LojaMoveis.bd.ConnectionUtils;
import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.bd.ItemVendaDAO;
import br.senac.LojaMoveis.bd.ItemVendas_ProdutosDAO;
import br.senac.LojaMoveis.registros.Cliente;
import br.senac.LojaMoveis.registros.Produto;
import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Beto
 */
public class TelaVendasController implements Initializable {

    @FXML
    private ComboBox comboBoxCliente;
    @FXML
    private DatePicker datePickerData;
    @FXML
    private TextField tfValor;
    @FXML
    private TableView<Vendas_Produtos> tabelaItensVendas;
    @FXML
    private TableColumn<Vendas_Produtos, Produto> colunaProduto;
    @FXML
    private TableColumn<Vendas_Produtos, Integer> colunaQuantidade;
    @FXML
    private TableColumn<Vendas_Produtos, Double> colunaValor;
    @FXML
    private ComboBox comboBoxProduto;
    @FXML
    private TextField tfQuantidade;
    @FXML
    private Button buttonAdicionar;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    private List<Cliente> listClientes;
    private List<Produto> listProdutos;
    private ObservableList<Cliente> observableListClientes;
    private ObservableList<Produto> observableListProdutos;
    private ObservableList<Vendas_Produtos> observableListItensDeVenda;

    //Atributos para manipulação de Banco de Dados
   
    
    private final ConnectionUtils connection = new ConnectionUtils();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ItemProdutoDAO produtoDAO = new ItemProdutoDAO();

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Vendas venda;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           
            
        try {
            carregarComboBoxClientes();
        } catch (Exception ex) {
            Logger.getLogger(TelaVendasController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            carregarComboBoxProdutos();
        } catch (Exception ex) {
            Logger.getLogger(TelaVendasController.class.getName()).log(Level.SEVERE, null, ex);
        }
            colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
            colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
            colunaValor.setCellValueFactory(new PropertyValueFactory<>("preco"));
       
    }

    public void carregarComboBoxClientes() throws Exception {
        listClientes = clienteDAO.listar();
        observableListClientes = FXCollections.observableArrayList(listClientes);
        comboBoxCliente.setItems(observableListClientes);
    }

    public void carregarComboBoxProdutos() throws Exception {
        listProdutos = produtoDAO.listar();
        observableListProdutos = FXCollections.observableArrayList(listProdutos);
        comboBoxProduto.setItems(observableListProdutos);
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Vendas getVenda() {
        return this.venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    @FXML
    public void handleButtonAdicionar() {
        Produto produto;
        Vendas_Produtos itemDeVenda = new Vendas_Produtos();
        if (comboBoxProduto.getSelectionModel().getSelectedItem() != null) {
            produto = (Produto) comboBoxProduto.getSelectionModel().getSelectedItem();
            if (produto.getEstoque()>= Integer.parseInt(tfQuantidade.getText())) {
                itemDeVenda.setProduto((Produto) comboBoxProduto.getSelectionModel().getSelectedItem());
                itemDeVenda.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
                itemDeVenda.setTotal(itemDeVenda.getProduto().getPreco() * itemDeVenda.getQuantidade());
                venda.getVendasProdutos().add(itemDeVenda);
                observableListItensDeVenda = FXCollections.observableArrayList(venda.getVendasProdutos());
                tabelaItensVendas.setItems(observableListItensDeVenda);
                tfValor.setText(String.format("%.2f", itemDeVenda.getTotal()));
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Problemas na escolha do produto!");
                alert.setContentText("Não existe a quantidade de produtos disponíveis no estoque!");
                alert.show();
            }
        }
    }

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
            venda.setCliente((Cliente) comboBoxCliente.getSelectionModel().getSelectedItem());            
            venda.setData(datePickerData.getValue());
            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    public void handleButtonCancelar() {
        getDialogStage().close();
    }

    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";
        if (comboBoxCliente.getSelectionModel().getSelectedItem() == null) {
            errorMessage += "Cliente inválido!\n";
        }
        if (datePickerData.getValue() == null) {
            errorMessage += "Data inválida!\n";
        }
        if (observableListItensDeVenda == null) {
            errorMessage += "Itens de Venda inválidos!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
}
