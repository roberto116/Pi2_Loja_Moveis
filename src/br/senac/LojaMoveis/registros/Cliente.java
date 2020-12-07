/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.registros;

import java.util.Date;

/**
 *
 * @author lenovo
 */
public class Cliente {
    public int id;
    public String nome;
    public String sobrenome;
    public Date nascimento;
    public int rg;
    public String endereco;
    public String bairro;
    public String cidade;
    public String estadoCivil;
    public int cpf;
    public int numero;
    public int cep;
    public String email;
    public int telefone;
    public String complemento;
    public String uf;
    public int celular;
    public String genero;
    
       public String getNome(){
        return nome;
    }
        public String getSobrenome(){
        return sobrenome;
    }
        public int getCpf(){
        return cpf;
    }
        public int getRg(){
        return rg;
    }
        public String getEmail(){
        return email;
    }
        public Date getNascimento(){
        return nascimento;
    }
        public String getEndereco(){
        return endereco;
    }
        public int getNumero(){
        return numero;
    }
        public String getBairro(){
        return bairro;
    }
        public String getCidade(){
        return cidade;
    }
        public String getEstadoCivil(){
        return estadoCivil;
    }
        public int getCep(){
        return cep;
    }
        public int getTelefone(){
        return telefone;
    }
        public String getComplemento(){
        return complemento;
    }
        public String getUf(){
        return uf;
    }
        public int getCelular(){
        return celular;
    }
        public String getGenero(){
        return genero;
    }
        public int getId(){
        return id;
    }
}


