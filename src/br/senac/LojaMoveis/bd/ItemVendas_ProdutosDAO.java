/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.bd;

import br.senac.LojaMoveis.registros.Vendas_Produtos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class ItemVendas_ProdutosDAO {
      
    public static void inserirVendasProdutos(Vendas_Produtos item,int idVenda)throws Exception{
        //Comando SQL para inserir na tabela vendas_produtos os dados necessarios
        String sql = "insert into vendas_produtos(idvenda,idProduto,quantidade,total) VALUES (?, ?, ?, ?)";
        
        //criando conexão com o banco 
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            //dados que serão inseridos 
            comando.setInt(1, idVenda);
            comando.setInt(2, item.idProduto);
            comando.setInt(3, item.quantidade);
            comando.setDouble(4, item.total);
            
            comando.execute();
            
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }

    }
}
