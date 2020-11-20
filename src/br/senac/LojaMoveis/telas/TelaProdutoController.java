/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.ItemProduto;
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
    private TextField tfQualidade;
    @FXML
    private TextField tfQuantidade;
    @FXML
    private TextField tfValor;
    @FXML
    private TextField tfPesquisar;
    @FXML
    private TableView<ItemProduto> tabelaProduto;
    @FXML
    private TableColumn<ItemProduto, String> colunaProduto;
    @FXML
    private TableColumn<ItemProduto, String> colunaCor;
    @FXML
    private TableColumn<ItemProduto, String> colunaQualidade;
    @FXML
    private TableColumn<ItemProduto, Integer> colunaQuantidade;
    @FXML
    private TableColumn<ItemProduto, Integer> colunaValor;
    @FXML
    private Button btnSalvar;
    
    //Variaveis globais
    boolean editMode = false;
    ItemProduto itemProdutoEdicao = null;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaQualidade.setCellValueFactory(new PropertyValueFactory("qualidade"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory("quantidade"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
    }    

    @FXML
    private void limparCampos(ActionEvent event) {
        tfProduto.clear();
        tfCor.clear();
        tfQualidade.clear();
        tfQuantidade.clear();
        tfValor.clear();
        
        btnSalvar.setText("Inserir");
        editMode = false;
    }

    @FXML
    private void inserir(ActionEvent event) {
        if(!editMode){
            ItemProduto item = new ItemProduto();
        
            item.produto = tfProduto.getText();
            item.cor = tfCor.getText();
            item.qualidade = tfQualidade.getText();
            item.quantidade = Integer.parseInt(tfQuantidade.getText());
            item.preco = Integer.parseInt(tfValor.getText());
       
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
            itemProdutoEdicao.produto = tfProduto.getText();
            itemProdutoEdicao.cor = tfCor.getText();
            itemProdutoEdicao.qualidade = tfQualidade.getText();
            itemProdutoEdicao.quantidade = Integer.parseInt(tfQuantidade.getText());
            itemProdutoEdicao.preco = Integer.parseInt(tfValor.getText());
            
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
                List<ItemProduto> resultado = ItemProdutoDAO.listar();

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
                List<ItemProduto> resultado = ItemProdutoDAO.pesquisar(tfPesquisar.getText());

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
        ItemProduto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        if(itemSelecionado != null){
            editMode = true;
            
            itemProdutoEdicao = itemSelecionado;
            
            tfProduto.setText(itemProdutoEdicao.produto);
            tfCor.setText(itemProdutoEdicao.cor);
            tfQualidade.setText(itemProdutoEdicao.qualidade);
            tfQuantidade.setText(String.valueOf(itemProdutoEdicao.quantidade));
            tfValor.setText(String.valueOf(itemProdutoEdicao.preco));            
            
            btnSalvar.setText("Salvar");
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
        ItemProduto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
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
