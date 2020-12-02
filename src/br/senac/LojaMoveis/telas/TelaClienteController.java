/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.registros.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Beto
 */
public class TelaClienteController implements Initializable {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfSobrenome;
    @FXML
    private TextField tfNascimento;
    @FXML
    private TextField tfRg;
    @FXML
    private TextField tfEndereco;
    @FXML
    private TextField tfBairro;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfEstadoCivil;
    @FXML
    private TextField tfCpf;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfTelefone;
    @FXML
    private TextField tfComplemento;
    @FXML
    private TextField tfUf;
    @FXML
    private TextField tfCelular;
    @FXML
    private TextField tfGenero;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaSobrenome;
    @FXML
    private TableColumn<Cliente, Integer> colunaRg;
    @FXML
    private TableColumn<Cliente, Integer> colunaCpf;
    @FXML
    private TableColumn<Cliente, Integer> colunaTelefone;
    @FXML
    private TableColumn<Cliente, Integer> colunaCelular;
    @FXML
    private TableColumn<Cliente, String> colunaCidade;
    @FXML
    private TextField tfPesquisa;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void limparCampos(ActionEvent event) {
        tfNome.clear();
        tfSobrenome.clear();
        tfNascimento.clear();
        tfRg.clear();
        tfEndereco.clear();
        tfBairro.clear();
        tfCidade.clear();
        tfEstadoCivil.clear();
        tfCpf.clear();
        tfNumero.clear();
        tfCep.clear();
        tfEmail.clear();
        tfTelefone.clear();
        tfComplemento.clear();
        tfUf.clear();
        tfCelular.clear();
        tfGenero.clear();
    }

    @FXML
    private void inserir(ActionEvent event) {
        
    }

    @FXML
    private void editar(ActionEvent event) {
        
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        
    }

    @FXML
    private void excluir(ActionEvent event) {
        
    }
    
}
