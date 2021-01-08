/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.registros;

/**
 * Aqui foi feito um registro do Produto onde cada variavel foi criada 
 * diacordo com a tabela Produto no bd
 */
public class Produto {
    public int id;
    public String produto;
    public String cor;
    public String marca;
    public int estoque;
    public double preco;
    
    //aqui esta deixano publico as variaves da classe Produto para que 
    //possa ser usada em outra classe
    
       public String getProduto(){
        return produto;
    }
        public String getCor(){
        return cor;
    }
        public String getMarca(){
        return marca;
    }
        public int getEstoque(){
        return estoque;
    }
        public double getPreco(){
        return preco;
    }
        public int getId(){
        return id;
    }
}
//
