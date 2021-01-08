/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.bd;

import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Lenovo
 */
public class ItemVendaDAO {
    public static int inserirVendas(Vendas item)throws Exception{
        //comando SQL para inserir vendas na tabela vendas
        String sql = "insert into vendas(idcliente,datavenda) VALUES (?, ?)";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando comando sql com o retorno de uma chave
            PreparedStatement comando = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            //dados que serão inseridos
            comando.setInt(1, item.idcliente);
            comando.setDate(2, (Date)( item.datavenda));
            
            comando.execute();
            
           //ResultSet para consultar a chave 
           ResultSet chavesGeradas = comando.getGeneratedKeys();
           
           //Se tiver chavesGeradas
            if(chavesGeradas.next()){
              //retornando a chave gerada
              return  chavesGeradas.getInt(1);  
           }
               
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
        //retornando '-1'
        return -1;
    }
   }
    


    