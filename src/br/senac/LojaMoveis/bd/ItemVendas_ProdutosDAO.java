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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    public static List<Vendas_Produtos> pesquisar() throws Exception{
        //Comando SQL para consultar um determinado registro
        String sql = "SELECT * FROM produto WHERE produto LIKE ?";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        //criando uma lista com o parametro 'Produto'
        List<Vendas_Produtos> lista = new ArrayList();
        
        try{
            //preparando o comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet dados = comando.executeQuery();
            
            //Enquando tiver dados sera executado
            while(dados.next()){
                //instanciando 'Produto'
                Vendas_Produtos item = new Vendas_Produtos();
                
                //dados que serão consultados 
                item.idProduto = dados.getInt("idProduto");
                item.quantidade = dados.getInt("quantidade");
                item.total = dados.getDouble("total");
                // adicionando na lista
                lista.add(item);
                
            }
            
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
        //retornando lista
        return lista;
    }
    
}
