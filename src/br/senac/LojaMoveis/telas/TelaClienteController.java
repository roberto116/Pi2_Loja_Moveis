/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.bd.ClienteDAO;
import br.senac.LojaMoveis.registros.Cliente;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
       //colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        //colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        //colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        //colunaQuantidade.setCellValueFactory(new PropertyValueFactory("estoque"));
        //colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
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
        Cliente cliente = new Cliente();
        
        cliente.nome = tfNome.getText();
        cliente.sobrenome = tfSobrenome.getText();
        cliente.nascimento = Date.valueOf(tfNascimento.getText());
        cliente.rg = Integer.parseInt(tfRg.getText());
        cliente.endereco = tfEndereco.getText();
        cliente.bairro = tfBairro.getText();
        cliente.cidade = tfCidade.getText();
        cliente.estadoCivil = tfEstadoCivil.getText();
        cliente.cpf = Integer.parseInt(tfCpf.getText());
        cliente.numero = Integer.parseInt(tfNumero.getText());
        cliente.cep = Integer.parseInt(tfCep.getText());
        cliente.email = tfEmail.getText();
        cliente.telefone = Integer.parseInt(tfTelefone.getText());
        cliente.complemento = tfComplemento.getText();
        cliente.uf = tfUf.getText();
        cliente.celular = Integer.parseInt(tfCelular.getText());
        cliente.genero = tfGenero.getText();
        
         try{
            ClienteDAO.inserir(cliente);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Inserido com Sucesso");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Valha ao Inserir");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
        }
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
