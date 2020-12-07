/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.registros;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class Vendas {
    
    public int id;
    public int idcliente;
    public Date datavenda;
    private List<Vendas_Produtos> itensDeVenda;
    private Cliente cliente;

   

    public int getId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setData(Date datavenda) {
        this.datavenda = datavenda;
    }

    

    public List<Vendas_Produtos> getVendasProdutos() {
        return itensDeVenda;
    }

    public void setItensDeVenda(List<Vendas_Produtos> itensDeVenda) {
        this.itensDeVenda = itensDeVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
