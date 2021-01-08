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
        //Comando SQL para inserir no bd
        String sql = "INSERT INTO cliente (nome, sobrenome, datanascimento, rg, cpf, telefone, celular, email, rua, "
                + "numero, bairro, complementos, uf, cep, genero, cidade, estadoCivil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando comando sql
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            //dados que serão inseridos no bd
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
            //fechando conexão com o banco
            conexao.close();
        }
    }
    
    public static void excluir(int id) throws Exception{
        //Comando SQL para deletar um registro no bd
        String sql = "DELETE FROM cliente WHERE id = ?";
        
        //criando conexão com o banco
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando comando SQL
            PreparedStatement comando = conexao.prepareStatement(sql);
            //registro que sera excluido do bd
            comando.setInt(1, id);
   
            comando.execute();
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
    }
    
    public static void editar(Cliente item) throws Exception{
        //Comando SQL para editar um registro no bd
        String sql = "UPDATE cliente SET nome = ?, sobrenome = ?, datanascimento = ?, rg = ?, cpf = ?, telefone = ?, celular = ?, email =?, rua = ?, "
                + "numero = ?, bairro = ?, complementos = ?, uf = ?, cep = ?, genero = ?, cidade = ?, estadoCivil = ? WHERE id = ?"; 
        
        //Criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            //preparando o comando SQL
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            //dados que serão editados
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
            //fechando conexão com o bd
            conexao.close();
        }
    }
    
    public static List<Cliente> listar() throws Exception{
        //comando SQL para listar os registros do bd
        String sql = "SELECT * FROM cliente";
        
        //Criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        //Criando um ArrayList com o parametro 'Cliente'
        List<Cliente> lista = new ArrayList();
        
        try{
            //preparando comando SQL
            PreparedStatement comando = conexao.prepareStatement(sql);
            //ResultSet para consultar os dados no bd
            ResultSet dados = comando.executeQuery();
            
            //Enquanto tiver dados sera executado
            while(dados.next()){
                //instanciano 'cliente'
                Cliente item = new Cliente();
                
                //dados q serão puxados do bd para listar para o usuario
                item.id = dados.getInt("id");
                item.nome = dados.getString("nome");
                item.sobrenome = dados.getString("sobrenome");
                item.rg = dados.getInt("rg");
                item.cpf = dados.getInt("cpf");
                item.telefone = dados.getInt("telefone");
                item.celular = dados.getInt("celular");
                item.cidade = dados.getString("cidade");
                //adicionando na ArrayList
                lista.add(item); 
            }
            
        }finally{
            //fechando conexão com o bd
            conexao.close();
        }
        //retornando a lista
        return lista;
    }
    
    public static List<Cliente> pesquisar(String cliente) throws Exception{
        //Comando SQL que pesquisa um determinado registro
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        
        //criando conexão com o bd
        Connection conexao = ConnectionUtils.getConnection();
        //criando uma lista com o parametro 'Cliente'
        List<Cliente> lista = new ArrayList();
        
        try{
            //preparando comando SQL
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, "%" + cliente + "%"); 
            ResultSet dados = comando.executeQuery();
            
            //Enquanto tiver dados sera executado
            while(dados.next()){
                //instanciando 'Cliente'
                Cliente item = new Cliente();
                
                //dados q serão consultados no bd
                item.id = dados.getInt("id");
                item.nome = dados.getString("nome");
                item.sobrenome = dados.getString("sobrenome");
                item.rg = dados.getInt("rg");
                item.cpf = dados.getInt("cpf");
                item.telefone = dados.getInt("telefone");
                item.celular = dados.getInt("celular");
                item.cidade = dados.getString("cidade");
                
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
}
