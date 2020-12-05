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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML
    private DatePicker data;
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private Button btnSalvar;
    
    //variaveis globais
    boolean edition = false;
    Cliente clienteEdition = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        colunaRg.setCellValueFactory(new PropertyValueFactory("rg"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        colunaCelular.setCellValueFactory(new PropertyValueFactory("celular"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        
        LocalDate hoje = LocalDate.now();
        data.setValue(hoje);
    }    

    @FXML
    private void limparCampos(ActionEvent event) {
        tfNome.clear();
        tfSobrenome.clear();
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
        
        btnSalvar.setText("Inserir");
    }
    
    void alert (String title, String msg, AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    boolean validarCliente(){
        int telefone, celular, cep, cpf, rg, numero;
        int qtd = 0;
        
        if(tfNome.getText().isEmpty()|| tfSobrenome.getText().isEmpty() || tfEndereco.getText().isEmpty() || tfBairro.getText().isEmpty() || 
           tfCidade.getText().isEmpty() || tfEstadoCivil.getText().isEmpty() || tfEmail.getText().isEmpty() || tfComplemento.getText().isEmpty() ||
           tfUf.getText().isEmpty() || tfGenero.getText().isEmpty()){
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText("Campos vazios");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
           
           return false; 
        }
        qtd = tfNome.getText().length();
            if(qtd > 15){
                alert("Erro", "'Nome' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfSobrenome.getText().length();
            if(qtd > 30){
                alert("Erro", "'Sobrenome' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfEndereco.getText().length();
            if(qtd > 50){
                alert("Erro", "'Endereço' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfBairro.getText().length();
            if(qtd > 30){
                alert("Erro", "'Bairro' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfCidade.getText().length();
            if(qtd > 30){
                alert("Erro", "'Cidade' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfEstadoCivil.getText().length();
            if(qtd > 10){
                alert("Erro", "'Estado Civil' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfEmail.getText().length();
            if(qtd > 50){
                alert("Erro", "'Email' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfComplemento.getText().length();
            if(qtd > 10){
                alert("Erro", "'Complemento' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfUf.getText().length();
            if(qtd > 2){
                alert("Erro", "'UF' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfGenero.getText().length();
            if(qtd > 10){
                alert("Erro", "'Genero' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfTelefone.getText().length();
            if(qtd > 9){
                alert("Erro", "'telefone' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfCelular.getText().length();
            if(qtd > 9){
                alert("Erro", "'Celular' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfCep.getText().length();
            if(qtd > 8){
                alert("Erro", "'CEP' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfCpf.getText().length();
            if(qtd > 11){
                alert("Erro", "'CPF' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        qtd = tfRg.getText().length();
            if(qtd > 9){
                alert("Erro", "'RG' ultrapasso o limite de caracteres", AlertType.ERROR);
                return false;
            }
        
        try{
            telefone = Integer.parseInt(tfTelefone.getText());
            celular = Integer.parseInt(tfCelular.getText());
            cep = Integer.parseInt(tfCep.getText());
            cpf = Integer.parseInt(tfCpf.getText());
            rg = Integer.parseInt(tfRg.getText());
            numero = Integer.parseInt(tfNumero.getText());
            
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Erro");
                alert.setHeaderText("Letras no lugar de numeros");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            return false;
        }
        
        return true;     
    }

    @FXML
    private void inserir(ActionEvent event) {
        
        if(!edition){
           
            if(validarCliente() == false){
                return;
            }
            
            Cliente cliente = new Cliente();
        
            cliente.nome = tfNome.getText();
            cliente.sobrenome = tfSobrenome.getText();
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

            LocalDate dataDigitada = data.getValue();
            cliente.nascimento = Date.valueOf(dataDigitada);

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
             
        }else{
            if(validarCliente() == false){
                return;
            }
            
            clienteEdition.nome = tfNome.getText();
            clienteEdition.sobrenome = tfSobrenome.getText();
            clienteEdition.rg = Integer.parseInt(tfRg.getText());
            clienteEdition.endereco = tfEndereco.getText();
            clienteEdition.bairro = tfBairro.getText();
            clienteEdition.cidade = tfCidade.getText();
            clienteEdition.estadoCivil = tfEstadoCivil.getText();
            clienteEdition.cpf = Integer.parseInt(tfCpf.getText());
            clienteEdition.numero = Integer.parseInt(tfNumero.getText());
            clienteEdition.cep = Integer.parseInt(tfCep.getText());
            clienteEdition.email = tfEmail.getText();
            clienteEdition.telefone = Integer.parseInt(tfTelefone.getText());
            clienteEdition.complemento = tfComplemento.getText();
            clienteEdition.uf = tfUf.getText();
            clienteEdition.celular = Integer.parseInt(tfCelular.getText());
            clienteEdition.genero = tfGenero.getText();

            LocalDate dataDigitada = data.getValue();
            clienteEdition.nascimento = Date.valueOf(dataDigitada);
            
            try{
                ClienteDAO.editar(clienteEdition);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salvar");
                alert.setHeaderText("Salvo com Sucesso");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
                
            }catch(Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salvar");
                alert.setHeaderText("Valha ao Salvar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        limparCampos(event);
        pesquisar(event);
        
    }

    @FXML
    private void editar(ActionEvent event) {
        Cliente clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
        
        if(clienteSelecionado != null){
            edition = true;
            
            clienteEdition = clienteSelecionado;
            
            tfNome.setText(clienteEdition.nome);
            tfSobrenome.setText(clienteEdition.sobrenome);
            tfRg.setText(String.valueOf(clienteEdition.rg));
            tfEndereco.setText(clienteEdition.endereco);
            tfBairro.setText(clienteEdition.bairro);
            tfCidade.setText(clienteEdition.cidade);
            tfEstadoCivil.setText(clienteEdition.estadoCivil);
            tfCpf.setText(String.valueOf(clienteEdition.cpf));
            tfNumero.setText(String.valueOf(clienteEdition.numero));
            tfCep.setText(String.valueOf(clienteEdition.cep));
            tfEmail.setText(clienteEdition.email);
            tfTelefone.setText(String.valueOf(clienteEdition.telefone));
            tfComplemento.setText(clienteEdition.complemento);
            tfUf.setText(clienteEdition.uf);
            tfCelular.setText(String.valueOf(clienteEdition.celular));
            tfGenero.setText(clienteEdition.genero);
            
           
            btnSalvar.setText("Salvar");
        }
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        if(tfPesquisa.getText().equals("")){
            try{
                List<Cliente> cliente =  ClienteDAO.listar();
                
                tabelaCliente.setItems(FXCollections.observableArrayList(cliente));
                tabelaCliente.refresh();
                
            }catch(Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }else{
            try{
                List<Cliente> cliente = ClienteDAO.pesquisar(tfPesquisa.getText());
                
                tabelaCliente.setItems(FXCollections.observableArrayList(cliente));
                tabelaCliente.refresh();
                
            }catch(Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        
    }

    @FXML
    private void excluir(ActionEvent event) {
        Cliente clienteSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
        
        if(clienteSelecionado != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Remoção");
            alert.setContentText("Remover o item " + clienteSelecionado.nome);
            
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get()== ButtonType.OK){
                try{
                    ClienteDAO.excluir(clienteSelecionado.id);
                    alert.setTitle("Excluir");
                    alert.setHeaderText("Excluido");
                    alert.setContentText("Click em OK para continuar");
                    alert.showAndWait();
                    
                }catch(Exception e){
                    e.printStackTrace();
                    alert.setTitle("Excluir");
                    alert.setHeaderText("Valha ao Excluir");
                    alert.setContentText("Click em OK para continuar");
                    alert.showAndWait();
                }
            }
            pesquisar(event);
        }
        
    }
    
}
