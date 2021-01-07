/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.Script;

/**
 *
 * @author Beto
 */
public class BD {
    /**
    CREATE DATABASE projeto_loja_moveis;
    use projeto_loja_moveis;

    create table cliente (
            id int primary key auto_increment,
            nome varchar(15) not null,
            sobrenome varchar(30) not null,
            datanascimento datetime,
            rg int(9),
            cpf int(11),
            telefone int(9),
            celular int(9),
            email varchar(50),
            rua varchar(50),
            numero int not null,
            bairro varchar(30),
            complementos varchar(10),
            uf varchar(2),
            cep int(8) not null,
            genero varchar(10),
            cidade varchar(30),
            estadoCivil varchar(10)
    );

    create table produto(
            id int primary key auto_increment,
            produto varchar(40) not null,
            cor varchar(10) not null,
            marca varchar(10) not null,
            estoque int not null,
            preco double not null
    );

    create table vendas(
            id int primary key auto_increment,
            idcliente int not null, 
            datavenda datetime not null,
            foreign key (idcliente) references cliente (id)
    );

    create table vendas_produtos(
            idvenda int not null,
            idProduto  int not null,
            quantidade int not null,
            total double not null, 
            primary key (idvenda, idProduto),
            foreign key (idvenda) references vendas(id),
            foreign key (idProduto) references produto(id)
    );

    DELIMITER $$
    CREATE TRIGGER ItensVendaInsert
     before INSERT ON vendas_produtos
     FOR EACH ROW
     BEGIN
     UPDATE Produto SET estoque = estoque - NEW.quantidade
     WHERE id = NEW.idproduto;
     END$$
    DELIMITER ;
    
    */
}
