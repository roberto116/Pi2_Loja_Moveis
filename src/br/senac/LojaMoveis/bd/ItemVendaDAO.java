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
    public static void inserirVendas(Vendas item)throws Exception{
        String sql = "insert into vendas(idcliente,datavenda) VALUES (?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
            
            comando.setInt(1, item.idcliente);
            comando.setDate(2, (Date)( item.datavenda));
            
            comando.execute();
            
            
           ResultSet chavesGeradas = comando.getGeneratedKeys();
          
           if(chavesGeradas.next()){
               chavesGeradas.getInt(1);
           }
               
        
            
            
        }finally{
            conexao.close();
        }

    }
   }
    


    