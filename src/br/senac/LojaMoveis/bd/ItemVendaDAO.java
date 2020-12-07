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

/**
 *
 * @author Lenovo
 */
public class ItemVendaDAO {
    public static void inserirVendas(Vendas item)throws Exception{
        String sql = "insert into vendas(idcliente,datavenda) VALUES (?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, item.idcliente);
            comando.setDate(2, Date.valueOf( item.datavenda));
            
            
        }finally{
            conexao.close();
        }

    }
   }
    


    