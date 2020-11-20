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
public class ItemProduto {
    public int id;
    public String produto;
    public String cor;
    public String qualidade;
    public int quantidade;
    public int preco;
    
       public String getProduto(){
        return produto;
    }
        public String getCor(){
        return cor;
    }
        public String getQualidade(){
        return qualidade;
    }
        public int getQuantidade(){
        return quantidade;
    }
        public int getPreco(){
        return preco;
    }
}


