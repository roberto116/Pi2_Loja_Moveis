/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.bd;

import br.senac.LojaMoveis.registros.Cliente;
import br.senac.LojaMoveis.registros.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beto
 */
public class ClienteDAO {
    public static void inserir(Cliente item)throws Exception{
        String sql = "INSERT INTO cliente (nome, sobrenome, datanascimento, rg, cpf, telefone, celular, email, rua, "
                + "numero, bairro, complementos, uf, cep, genero, cidade, estadoCivil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.nome);
            comando.setString(2, item.sobrenome);
            comando.setDate(3, (Date) item.nascimento);
            comando.setInt(4, item.rg);
            comando.setInt(5, item.cpf);
            comando.setInt(6, item.telefone);
            comando.setInt(7, item.celular);
            comando.setString(8, item.email);
            comando.setString(9, item.bairro);
            comando.setInt(10, item.numero);
            comando.setString(11, item.bairro);
            comando.setString(12, item.complemento);
            comando.setString(13, item.uf);
            comando.setInt(14, item.cep);
            comando.setString(15, item.genero);
            comando.setString(16, item.cidade);
            comando.setString(17, item.estadoCivil);
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
    
    public static void excluir(int id) throws Exception{
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setInt(1, id);
   
            comando.execute();
        }finally{
            conexao.close();
        }
    }
    
    public static void editar(Cliente item) throws Exception{
        String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, datanascimento = ?, rg = ?, cpf = ?, telefone = ?, celular = ?, email =?, rua = ?, "
                + "numero = ?, bairro = ?, complementos = ?, uf = ?, cep = ?, genero = ?, cidade = ?, estadoCivil = ? WHERE id = ?"; 
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.nome);
            comando.setString(2, item.sobrenome);
            comando.setDate(3, (Date) item.nascimento);
            comando.setInt(4, item.rg);
            comando.setInt(5, item.cpf);
            comando.setInt(6, item.telefone);
            comando.setInt(7, item.celular);
            comando.setString(8, item.email);
            comando.setString(9, item.bairro);
            comando.setInt(10, item.numero);
            comando.setString(11, item.bairro);
            comando.setString(12, item.complemento);
            comando.setString(13, item.uf);
            comando.setInt(14, item.cep);
            comando.setString(15, item.genero);
            comando.setString(16, item.cidade);
            comando.setString(17, item.estadoCivil);
            comando.setInt(18, item.id);
            
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
    
    public static List<Cliente> listar() throws Exception{
        String sql = "SELECT * FROM cliente";
        
        Connection conexao = ConnectionUtils.getConnection();
        List<Cliente> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                Cliente item = new Cliente();
                
                item.id = dados.getInt("id");
                item.nome = dados.getString("nome");
                item.sobrenome = dados.getString("sobrenome");
                item.rg = dados.getInt("rg");
                item.cpf = dados.getInt("cpf");
                item.telefone = dados.getInt("telefone");
                item.celular = dados.getInt("celular");
                item.cidade = dados.getString("cidade");
                lista.add(item); 
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
    
    public static List<Cliente> pesquisar(String cliente) throws Exception{
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        
        Connection conexao = ConnectionUtils.getConnection();
        List<Cliente> lista = new ArrayList();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, "%" + cliente + "%");
            
            ResultSet dados = comando.executeQuery();
            
            while(dados.next()){
                Cliente item = new Cliente();
                
                item.id = dados.getInt("id");
                item.nome = dados.getString("nome");
                item.sobrenome = dados.getString("sobrenome");
                item.rg = dados.getInt("rg");
                item.cpf = dados.getInt("cpf");
                item.telefone = dados.getInt("telefone");
                item.celular = dados.getInt("celular");
                item.cidade = dados.getString("cidade");
                
                lista.add(item);
                
            }
            
        }finally{
            conexao.close();
        }
        
        return lista;
    }
}
