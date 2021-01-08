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
        //Comando SQL q sera executado para inserir no bd
        String sql = "INSERT INTO produto (produto, cor, marca, estoque, preco) VALUES (?, ?, ?, ?, ?)";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            //dados q serão inseridos no bd
            comando.setString(1, item.produto);
            comando.setString(2, item.cor);
            comando.setString(3, item.marca);
            comando.setInt(4, item.estoque);
            comando.setDouble(5, item.preco);
            comando.execute();
            
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
    }
    
    public static void excluir(int id) throws Exception{
        //Comando SQL para excluir um registro
        String sql = "DELETE FROM produto WHERE id = ?";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            //registro que sera excluido
            comando.setInt(1, id);
   
            comando.execute();
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
    }
    
    public static List<Produto> listar() throws Exception{
        //comando SQL para listar os registro
        String sql = "SELECT * FROM produto";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        //criando uma lista com o parametro 'Produto'
        List<Produto> lista = new ArrayList();
        
        try{
            //preparando comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            //ResultSet para fazer a consulta no bd
            ResultSet dados = comando.executeQuery();
            
            //Enquanto tiver dados sera executado 
            while(dados.next()){
                //instanciando 'Produto'
                Produto item = new Produto();
                
                //dados que serão consultados
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.cor = dados.getString("cor");
                item.marca = dados.getString("marca");
                item.estoque = dados.getInt("estoque");
                item.preco = dados.getDouble("preco");
                
                //adicionando na lista
                lista.add(item); 
            }
            
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
        //retornando lista
        return lista;
    }
    
    public static List<Produto> pesquisar(String produto) throws Exception{
        //Comando SQL para consultar um determinado registro
        String sql = "SELECT * FROM produto WHERE produto LIKE ?";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        //criando uma lista com o parametro 'Produto'
        List<Produto> lista = new ArrayList();
        
        try{
            //preparando o comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "%" + produto + "%");
            ResultSet dados = comando.executeQuery();
            
            //Enquando tiver dados sera executado
            while(dados.next()){
                //instanciando 'Produto'
                Produto item = new Produto();
                
                //dados que serão consultados 
                item.id = dados.getInt("id");
                item.produto = dados.getString("produto");
                item.cor = dados.getString("cor");
                item.marca = dados.getString("marca");
                item.estoque = dados.getInt("estoque");
                item.preco = dados.getDouble("preco");
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
    
    public static void editar(Produto item) throws Exception{
        //comando sql para editar um registro no bd
        String sql = "UPDATE produto SET produto = ?, cor = ?, marca = ?, estoque = ?, preco = ? WHERE id = ?"; 
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            
            PreparedStatement comando = conexao.prepareStatement(sql);
            //dados q serão editados
            comando.setString(1, item.produto);
            comando.setString(2, item.cor);
            comando.setString(3, item.marca);
            comando.setInt(4, item.estoque);
            comando.setDouble(5, item.preco);
            comando.setInt(6, item.id);
            
            comando.execute();
            
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
    }
}
