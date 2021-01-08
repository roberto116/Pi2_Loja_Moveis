package br.senac.LojaMoveis.bd;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Beto
 */
public class ConnectionUtils {
 
    //funcão que é responsavel pela conexão com o banco de dados
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_loja_moveis?useTimezone=true&serverTimezone=UTC",
                                           "root",
                                           "1234");
    }
    
    //função para testar conexão com o bd
    public static void main(String[] args){
        try{
            getConnection();
            System.out.println("conectado");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
