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
      public static void inserirVendasProdutos(Vendas_Produtos item)throws Exception{
        String sql = "insert into vendas(idvenda,idproduto,estoque,total) VALUES (?, ?, ?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, item.idvenda);
            comando.setInt(2, item.idProduto);
            comando.setInt(3, item.quantidade);
            comando.setDouble(4, item.total);
            
            comando.execute();
            
        }finally{
            conexao.close();
        }

    }
}
