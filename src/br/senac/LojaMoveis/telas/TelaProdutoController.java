/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.Produto;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Beto
 */
public class TelaProdutoController implements Initializable {

    @FXML
    private TextField tfProduto;
    @FXML
    private TextField tfCor;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfQuantidade;
    @FXML
    private TextField tfValor;
    @FXML
    private TextField tfPesquisar;
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
    private Button btnSalvar;
    
    //Variaveis globais
    boolean editMode = false;
    Produto itemProdutoEdicao = null;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory("estoque"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
    }    

    @FXML
    private void limparCampos(ActionEvent event) {
        tfProduto.clear();
        tfCor.clear();
        tfMarca.clear();
        tfQuantidade.clear();
        tfValor.clear();
        
        btnSalvar.setText("Inserir");
        editMode = false;
    }
    
     void alert (String title, String msg, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    boolean validarProduto(){
        int quantidade = 0;
        double preco = 0;
        int qtd = 0;
        
        if(tfProduto.getText().isEmpty() || tfCor.getText().isEmpty() || tfMarca.getText().isEmpty()){
            return false;
        }
        
        qtd = tfProduto.getText().length();
            if(qtd > 40){
                alert("Erro", "'Produto' ultrapasso o limite de caracteres", Alert.AlertType.ERROR);
                return false;
            }
        qtd = tfCor.getText().length();
            if(qtd > 10){
                alert("Erro", "'Cor' ultrapasso o limite de caracteres", Alert.AlertType.ERROR);
                return false;
            }
        qtd = tfMarca.getText().length();
            if(qtd > 10){
                alert("Erro", "'Marca' ultrapasso o limite de caracteres", Alert.AlertType.ERROR);
                return false;
            }
        
        try{
            quantidade = Integer.parseInt(tfQuantidade.getText());
            preco = Double.parseDouble(tfValor.getText());
            
        }catch(Exception e){
            return false;
        }
        
        return true;
    }

    @FXML
    private void inserir(ActionEvent event) {
        if(!editMode){
            
            if(validarProduto() == false){
                return;
            }
            
            Produto item = new Produto();
        
            item.produto = tfProduto.getText();
            item.cor = tfCor.getText();
            item.marca = tfMarca.getText();
            item.estoque = Integer.parseInt(tfQuantidade.getText());
            item.preco = Double.parseDouble(tfValor.getText());
            

        try{
            ItemProdutoDAO.inserir(item);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Inserido com Sucesso");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Valha ao Inserir");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
        }
            
        }else{
            
            if(validarProduto() == false){
                return;
            }
            
            itemProdutoEdicao.produto = tfProduto.getText();
            itemProdutoEdicao.cor = tfCor.getText();
            itemProdutoEdicao.marca = tfMarca.getText();
            itemProdutoEdicao.estoque = Integer.parseInt(tfQuantidade.getText());
            itemProdutoEdicao.preco = Double.parseDouble(tfValor.getText());
            
            try {
                ItemProdutoDAO.editar(itemProdutoEdicao);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salvar");
                alert.setHeaderText("Salvo com Sucesso");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
                
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salvar");
                alert.setHeaderText("Valha ao Salvar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            } 
        }
        limparCampos(event);
        pesquisar(event);
        
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        if(tfPesquisar.getText().equals("")){
            try{
                List<Produto> resultado = ItemProdutoDAO.listar();

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        else {
            try{
                List<Produto> resultado = ItemProdutoDAO.pesquisar(tfPesquisar.getText());

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
    }

    @FXML
    private void editar(ActionEvent event) {
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        if(itemSelecionado != null){
            editMode = true;
            
            itemProdutoEdicao = itemSelecionado;
            
            tfProduto.setText(itemProdutoEdicao.produto);
            tfCor.setText(itemProdutoEdicao.cor);
            tfMarca.setText(itemProdutoEdicao.marca);
            tfQuantidade.setText(String.valueOf(itemProdutoEdicao.estoque));
            tfValor.setText(String.valueOf(itemProdutoEdicao.preco));            
            
            btnSalvar.setText("Salvar");
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        if(itemSelecionado != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Remoção");
            alert.setContentText("Remover o item " + itemSelecionado.produto);
            
            Optional<ButtonType> resultado = alert.showAndWait();
                if(resultado.get() == ButtonType.OK){
                    try {
                    ItemProdutoDAO.excluir(itemSelecionado.id);
                    alert.setTitle("Excluir");
                    alert.setHeaderText("Excluido");
                    alert.setContentText("Click em OK para continuar");
                    alert.showAndWait();

                } catch (Exception e) {
                    e.printStackTrace();
                    alert.setTitle("Excluir");
                    alert.setHeaderText("Valha ao Excluir");
                    alert.setContentText("Click em OK para continuar");
                    alert.showAndWait();
                } 
            }
            pesquisar(event);
        }
    }
    
}
