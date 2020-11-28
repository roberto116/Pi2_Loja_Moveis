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
import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.Produto;
import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import java.net.URL;
import java.util.ArrayList;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
         colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory("estoque"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
       
    }    
       

    @FXML
    private void finalizar(ActionEvent event) {
        
        
    }

    
    @FXML
    private void pesquisar(ActionEvent event) {
        if(tfPesquisar.getText().equals("")){
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
                List<Produto> resultado = ItemProdutoDAO.pesquisar(tfPesquisar.getText());

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
        
        
    
       
}
    

   
    
    

