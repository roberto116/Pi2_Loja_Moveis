
package br.senac.LojaMoveis.registros;

/**
 * Aqui foi feito um registro do Vendas_Produtos onde cada variavel foi criada 
 * diacordo com a tabela Vendas_Produto no bd
 */
public class Vendas_Produtos {
    
    public int idvenda;
    public int idProduto;
    public int quantidade;
    public double total;
         
    //aqui esta deixano publico as variaves da classe Vendas_Produto para que 
    //possa ser usada em outra classe
    
    public int getIdVenda(){
        return idvenda;
    } 
    
    public int getIdProduto(){
        return idProduto;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public double getTotal(){
        return total;
    }
}
