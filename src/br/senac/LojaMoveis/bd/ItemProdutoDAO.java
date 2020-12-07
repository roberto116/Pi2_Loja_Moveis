/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.bd;

import br.senac.LojaMoveis.registros.Produto;
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
    
    public static void inserir(Produto item)throws Exception{
        String sql = "INSERT INTO produto (produto, cor, marca, estoque, preco) VALUES (?, ?, ?, ?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.produto);
            comando.setString(2, item.cor);
            comando.setString(3, item.marca);
            comando.setInt(4, item.estoque);
            comando.setDouble(5, item.preco);
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
    
    public static List<Produto> listar() throws Exception{
        String sql = "SELECT * FROM produto";
        
        Connection conexao = ConnectionUtils.getConnection();
        List<Produto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                Produto item = new Produto();
                
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.cor = dados.getString("cor");
                item.marca = dados.getString("marca");
                item.estoque = dados.getInt("estoque");
                item.preco = dados.getDouble("preco");
                lista.add(item); 
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static List<Produto> pesquisar(String produto) throws Exception{
        String sql = "SELECT * FROM produto WHERE produto LIKE ?";
        
        Connection conexao = ConnectionUtils.getConnection();
        List<Produto> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, "%" + produto + "%");
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                Produto item = new Produto();
                
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.cor = dados.getString("cor");
                item.marca = dados.getString("marca");
                item.estoque = dados.getInt("estoque");
                item.preco = dados.getDouble("preco");
                
                lista.add(item);
                
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static void editar(Produto item) throws Exception{
        String sql = "UPDATE produto SET produto = ?, cor = ?, marca = ?, estoque = ?, preco = ? WHERE id = ?"; 
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.produto);
            comando.setString(2, item.cor);
            comando.setString(3, item.marca);
            comando.setInt(4, item.estoque);
            comando.setDouble(5, item.preco);
            comando.setInt(6, item.id);
            
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
}
