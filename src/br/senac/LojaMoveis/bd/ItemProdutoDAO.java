/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.bd;

import br.senac.LojaMoveis.registros.ItemProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beto
 */
public class ItemProdutoDAO {
    
    public static void inserir(ItemProduto item)throws Exception{
        String sql = "INSERT INTO produto (produto, cor, qualidade, quantidade, preco) VALUES (?, ?, ?, ?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.produto);
            comando.setString(2, item.cor);
            comando.setString(3, item.qualidade);
            comando.setInt(4, item.quantidade);
            comando.setInt(5, item.preco);
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
    
    public static void excluir(int id) throws Exception{
        String sql = "DELETE FROM produto WHERE id = ?";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, id);
   
            comando.execute();
        }finally{
            conexao.close();
        }
    }
    
    public static List<ItemProduto> listar() throws Exception{
        String sql = "SELECT * FROM produto";
        
        Connection conexao = ConnectionUtils.getConnection();
        List<ItemProduto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                ItemProduto item = new ItemProduto();
                
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.cor = dados.getString("cor");
                item.qualidade = dados.getString("qualidade");
                item.quantidade = dados.getInt("quantidade");
                item.preco = dados.getInt("preco");
                lista.add(item); 
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static List<ItemProduto> pesquisar(String produto) throws Exception{
        String sql = "SELECT * FROM produto WHERE produto LIKE ?";
        
        Connection conexao = ConnectionUtils.getConnection();
        List<ItemProduto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, "%" + produto + "%");
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                ItemProduto item = new ItemProduto();
                
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.cor = dados.getString("cor");
                item.qualidade = dados.getString("qualidade");
                item.quantidade = dados.getInt("quantidade");
                item.preco = dados.getInt("preco");
                
                lista.add(item);
                
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static void editar(ItemProduto item) throws Exception{
        String sql = "UPDATE produto SET produto = ?, cor = ?, qualidade = ?, quantidade = ?, preco = ? WHERE id = ?"; 
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.produto);
            comando.setString(2, item.cor);
            comando.setString(3, item.qualidade);
            comando.setInt(4, item.quantidade);
            comando.setInt(5, item.preco);
            comando.setInt(6, item.id);
            
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
}
