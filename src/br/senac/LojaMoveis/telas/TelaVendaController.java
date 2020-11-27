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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TableView<?> tabelaproduto;
    @FXML
    private TableView<?> tabelacliente;
    @FXML
    private TableColumn<?, ?> Colunacodigo;
    @FXML
    private TableColumn<?, ?> colunaproduto;
    @FXML
    private TableColumn<?, ?> colunaestoque;
    @FXML
    private TableColumn<?, ?> colunavalor;
    @FXML
    private TableColumn<?, ?> colunacodigocliente;
    @FXML
    private TableColumn<?, ?> colunanome;
    @FXML
    private TableColumn<?, ?> colunacpf;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Colunacodigo.setCellValueFactory(new PropertyValueFactory("id"));
        //colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        //colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        //colunaQuantidade.setCellValueFactory(new PropertyValueFactory("quantidade"));
        //colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
    }    
       

    @FXML
    private void finalizar(ActionEvent event) {
        
        
    }
    
}
