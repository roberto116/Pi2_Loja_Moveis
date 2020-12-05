/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;
//import br.senac.LojaMoveis.bd.ItemProdutoDAO;
//import br.senac.LojaMoveis.registros.Produto;
//import br.senac.LojaMoveis.registros.Vendas;
//import br.senac.LojaMoveis.registros.Vendas_Produtos;
import br.senac.LojaMoveis.bd.ClienteDAO;
import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.Cliente;
import br.senac.LojaMoveis.registros.Produto;
import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class TelaVendaController implements Initializable {

    @FXML
    private TextField tfQtd;
    @FXML
    private Label tfValorTotal;
    @FXML
    private TableView<Produto> tabelaProduto;
    @FXML
    private TableColumn<Produto, String> colunaProduto;
    @FXML
    private TableColumn<Produto, String> colunaCor;
    @FXML
    private TableColumn<Produto, String> colunaMarca;
    @FXML
    private TableColumn<Produto, Integer> colunaQuantidade;
    @FXML
    private TableColumn<Produto, Integer> colunaValor;
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaSobrenome;
    @FXML
    private TableColumn<Cliente, Integer> colunaRg;
    @FXML
    private TableColumn<Cliente, Integer> colunaCpf;
    @FXML
    private TableColumn<Cliente, Integer> colunaTelefone;
    @FXML
    private TableColumn<Cliente, Integer> colunaCelular;
    @FXML
    private TableColumn<Cliente, String> colunaCidade;
    @FXML
    private TextField tfPesquisarProd;
    @FXML
    private TextField tfPesquisaCliente;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory("estoque"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
        
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        colunaRg.setCellValueFactory(new PropertyValueFactory("rg"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        colunaCelular.setCellValueFactory(new PropertyValueFactory("celular"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
       
    }    
       

    @FXML
    private void finalizar(ActionEvent event) {
        
        Vendas_Produtos item = new Vendas_Produtos();
        Vendas venda = new Vendas();
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();       
               
        venda.datavenda = d;
        //venda.idcliente;
        item.idProduto = itemSelecionado.id ;
        item.idvenda = venda.id;
        item.quantidade = Integer.parseInt(tfQtd.getText());
        item.total = Double.parseDouble(tfValorTotal.getText());
     
        
    }

    
    private void pesquisar(ActionEvent event) {
        if(tfPesquisarProd.getText().equals("")){
            try{
                List<Produto> resultado = ItemProdutoDAO.listar();

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        else {
            try{
                List<Produto> resultado = ItemProdutoDAO.pesquisar(tfPesquisarProd.getText());

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
}
    }          

    @FXML
    private void calcular(ActionEvent event)
    {
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        
        int valor = Integer.parseInt(tfQtd.getText());
        
       
        if(valor < itemSelecionado.preco && valor > 0)
        {
            try{
                double Calc = itemSelecionado.preco * valor;
        
                String CalcTotal = "" + Calc;
        
                tfValorTotal.setText(CalcTotal);
            }
            catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Calcular");
                alert.setHeaderText("Falha no Calculo,Tente Novamente");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
        else
        {
            try{
             Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Calcular");
                alert.setHeaderText("Quantidade Invalida,Verifique o estoque");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
             catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Calcular");
                alert.setHeaderText("Falha no Calculo,Tente Novamente");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
        
    }

    @FXML
    private void pesquisarProd(ActionEvent event) 
    {
          if(tfPesquisarProd.getText().equals("")){
            try{
                List<Produto> resultado = ItemProdutoDAO.listar();

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        else {
            try{
                List<Produto> resultado = ItemProdutoDAO.pesquisar(tfPesquisarProd.getText());

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        } 
    }

    @FXML
    private void pesquisarClie(ActionEvent event) 
    {
           if(tfPesquisaCliente.getText().equals("")){
            try{
                List<Cliente> resultado = ClienteDAO.listar();

                tabelaCliente.setItems(FXCollections.observableArrayList(resultado));
                tabelaCliente.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        else {
            try{
                List<Cliente> resultado = ClienteDAO.pesquisar(tfPesquisaCliente.getText());

                tabelaCliente.setItems(FXCollections.observableArrayList(resultado));
                tabelaCliente.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
    }
        
        
    
       
}
    

   
    
    

