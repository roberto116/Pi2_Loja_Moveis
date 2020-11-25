/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class TelaVendaController implements Initializable {

    @FXML
    private ComboBox<?> cbProduto;
    @FXML
    private TextField tfQtd;
    @FXML
    private Label tfValorTotal;
    @FXML
    private ComboBox<?> cbCliente;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void finalizar(ActionEvent event) {
    }
    
}
