/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.registros;

/**
 *
 * @author lenovo
 */
public class Cliente {
    public int id;
    public String nome;
    public String sobrenome;
    public int cpf;
    public String email;
    public int rg; 
    public double datanascimento;
    
       public String getNome(){
        return nome;
    }
        public String getSobrenome(){
        return sobrenome;
    }
        public Integer getCpf(){
        return cpf;
    }
        public int getRg(){
        return rg;
    }
            public String getEmail(){
        return email;
    }
        public double getDataNascimento(){
        return datanascimento;
    }
}


