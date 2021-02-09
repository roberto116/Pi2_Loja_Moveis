/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.app;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Beto
 */
public class Aplicacao extends Application{
    
    // inicializando aplicação

    /**
     *
     * @param args
     */
    public static void main(String []args){
        launch(args);
    }
    
    //tela que sera iniciada assim q executar o programa
    @Override
    public void start (Stage stage) throws IOException{
        URL url = getClass().getResource("/br/senac/LojaMoveis/telas/TelaInicial.fxml");
        
        Parent TelaPrincipal = FXMLLoader.load(url);
        
        Scene scene = new Scene(TelaPrincipal);
        stage.setScene(scene);
        stage.show();
    }
}
