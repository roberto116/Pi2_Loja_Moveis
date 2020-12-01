
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.registros.Cliente;
import br.senac.LojaMoveis.registros.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaCadastroClienteController implements Initializable {
    @FXML
    private TextField tfNome;
    
    @FXML
    private TextField tfSobrenome;
    
    @FXML
    private TextField tfDataNascimento;
    
    @FXML
    private TextField tfRG;
    
    @FXML
    private TextField tfCPF;
    
    @FXML
    private TextField tfRua;
    
    @FXML
    private TextField tfBairro;
    
    @FXML
    private TextField tfNumero;
    
    @FXML
    private TextField tfCidade;
    
    @FXML
    private TextField tfUF;
    
    @FXML
    private TextField tfCEP;

    @FXML
    private Label tfDadosPessoais;
    
    @FXML
    private Label tfContato;
    
    @FXML
    private Label tfEndereco;
    
    @FXML
     private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn<Cliente, String> colunaCPF;
    @FXML
    private TableColumn<Produto, Integer> colunaNome;
    
     @FXML
    private Button btnSalvar;
     
     @FXML
     private Button btnPesquisar;

    
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory("nome"));
    }    
    
        @FXML
    private void limparCampos(ActionEvent event) {
        tfNome.clear();
        tfSobrenome.clear();
        tfDataNascimento.clear();
        tfCPF.clear();
        tfRG.clear();
        tfRua.clear();
        tfNumero.clear();
        tfBairro.clear();
        tfUF.clear();
        tfCEP.clear();
        
        btnSalvar.setText("Inserir");
        //editMode = false;
    }
    
        
    }    
    

