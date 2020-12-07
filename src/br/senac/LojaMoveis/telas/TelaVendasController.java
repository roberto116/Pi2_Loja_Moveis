/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Beto
 */
public class TelaVendasController implements Initializable {

    @FXML
    private ComboBox<?> comboBoxCliente;
    @FXML
    private DatePicker datePickerData;
    @FXML
    private TextField tfValor;
    @FXML
    private TableView<?> tabelaItensVendas;
    @FXML
    private TableColumn<?, ?> colunaProduto;
    @FXML
    private TableColumn<?, ?> colunaQuantidade;
    @FXML
    private TableColumn<?, ?> colunaValor;
    @FXML
    private ComboBox<?> comboBoxProduto;
    @FXML
    private TextField tfQuantidade;
    @FXML
    private Button buttonAdicionar;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
