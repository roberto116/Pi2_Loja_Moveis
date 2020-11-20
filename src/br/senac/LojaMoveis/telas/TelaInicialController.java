/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Beto
 */
public class TelaInicialController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void abrirTelaCliente(ActionEvent event) {
        
    }

    @FXML
    private void abrirTelaProduto(ActionEvent event) throws Exception {
         URL url = getClass().getResource("/br/senac/LojaMoveis/telas/TelaProduto.fxml");
        
        Parent TelaPrincipal = FXMLLoader.load(url);
        
        Scene scene = new Scene(TelaPrincipal);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirTelaVenda(ActionEvent event) {
        
    }

    @FXML
    private void abrirTelaRelatorio(ActionEvent event) {
        
    }
    
}