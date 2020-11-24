/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.registros;

/**
 *
 * @author Beto
 */
public class Produto {
    public int id;
    public String produto;
    public String cor;
    public String marca;
    public int quantidade;
    public double preco;
    
       public String getProduto(){
        return produto;
    }
        public String getCor(){
        return cor;
    }
        public String getMarca(){
        return marca;
    }
        public int getQuantidade(){
        return quantidade;
    }
        public double getPreco(){
        return preco;
    }
}
//
