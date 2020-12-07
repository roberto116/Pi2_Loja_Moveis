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
  
    public int getId() {
        return id;
    }

    public int getIdCliente(int id) {
        return idcliente;
    }

    public Date getDatavenda() {
        return datavenda;
    }
    
}
