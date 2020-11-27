/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.registros;

/**
 *
 * @author Lenovo
 */
public class Vendas_Produtos {
    
    public int idvenda;
    public int idProduto;
    public int quantidade;
    public double total;
         
        public int getQuantidade(){
        return quantidade;
    }
        public double getTotal(){
        return total;
    }
    
}
