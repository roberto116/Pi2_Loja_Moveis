/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.registros.itemProduto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableView<itemProduto> tabelaProduto;
    @FXML
    private TableColumn<itemProduto, String> colunaProduto;
    @FXML
    private TableColumn<itemProduto, String> colunaCor;
    @FXML
    private TableColumn<itemProduto, String> colunaQualidade;
    @FXML
    private TableColumn<itemProduto, ?> colunaQuantidade;
    @FXML
    private TableColumn<itemProduto, ?> colunaValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaQualidade.setCellValueFactory(new PropertyValueFactory("qualidade"));
        //colunaQuantidade.setCellValueFactory(new PropertyValueFactory("quantidade"));
        //colunaValor.setCellValueFactory(new PropertyValueFactory("valor"));
    }    

    @FXML
    private void limparCampos(ActionEvent event) {
        tfProduto.clear();
        tfCor.clear();
        tfQualidade.clear();
        tfQuantidade.clear();
        tfValor.clear();
    }

    @FXML
    private void inserir(ActionEvent event) {
        
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        
    }

    @FXML
    private void editar(ActionEvent event) {
        
    }

    @FXML
    private void excluir(ActionEvent event) {
        
    }
    
}
