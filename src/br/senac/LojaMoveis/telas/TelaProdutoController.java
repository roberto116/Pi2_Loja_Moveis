/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;

import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.Produto;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Beto
 */
public class TelaProdutoController implements Initializable {

    @FXML
    private TextField tfProduto;
    @FXML
    private TextField tfCor;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfQuantidade;
    @FXML
    private TextField tfValor;
    @FXML
    private TextField tfPesquisar;
    @FXML
    private TableView<Produto> tabelaProduto;
    @FXML
    private TableColumn<Produto, String> colunaProduto;
    @FXML
    private TableColumn<Produto, String> colunaCor;
    @FXML
    private TableColumn<Produto, String> colunaMarca;
    @FXML
    private TableColumn<Produto, Integer> colunaQuantidade;
    @FXML
    private TableColumn<Produto, Integer> colunaValor;
    @FXML
    private Button btnSalvar;
    
    //Variaveis globais
    boolean editMode = false;
    Produto itemProdutoEdicao = null;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /**
         * está sendo inicializado assim que abri a tela de Produto
         * todas as colunas da tabela
         */
        colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory("estoque"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
    }    

    @FXML
    private void limparCampos(ActionEvent event) {
        // aqui esta limpando os dados digitados nas textField
        tfProduto.clear();
        tfCor.clear();
        tfMarca.clear();
        tfQuantidade.clear();
        tfValor.clear();
        
        //botão recebe o nome Inserir
        btnSalvar.setText("Inserir");
        
        //variavel global recebe false
        editMode = false;
    }
    
    //função feita para dar os alertas para o usuario
     void alert (String title, String msg, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    //função feita para validar os dados digitados
    boolean validarProduto(){
        int quantidade = 0;
        double preco = 0;
        int qtd = 0;
        
        //se alguma dessas variaveis estiver vazias sera retornado 'false' 
        if(tfProduto.getText().isEmpty() || tfCor.getText().isEmpty() || tfMarca.getText().isEmpty()){
            alert("Erro", "Campos vazios", Alert.AlertType.ERROR);
            return false;
        }
        
        /**
         * Aqui esta propramado para validar uma por uma para não dar erro ou 
         * conflito com o bd. Nessa validação o sistema ver a quantidade de caracteres 
         * diacordo com o bd, se ultrapassar o valor definido a função retorna 'False'
         */
        
        qtd = tfProduto.getText().length();
            if(qtd > 40){
                alert("Erro", "'Produto' ultrapasso o limite de caracteres", Alert.AlertType.ERROR);
                return false;
            }
        qtd = tfCor.getText().length();
            if(qtd > 10){
                alert("Erro", "'Cor' ultrapasso o limite de caracteres", Alert.AlertType.ERROR);
                return false;
            }
        qtd = tfMarca.getText().length();
            if(qtd > 10){
                alert("Erro", "'Marca' ultrapasso o limite de caracteres", Alert.AlertType.ERROR);
                return false;
            }
        
         /**
         * nessa try-catch esta fazendo a validação para que se alguma campo que
         * deveria so receber valor numerico receber String, vai ser lançado 
         * uma alerta para o usuario e a função retornar 'false'
         */
            
        try{
            quantidade = Integer.parseInt(tfQuantidade.getText());
            preco = Double.parseDouble(tfValor.getText());
            
        }catch(Exception e){
            alert("Erro", "Letras no lugar de numeros", Alert.AlertType.ERROR);
            return false;
        }
        //caso não entre em nenhum if ou try-catch a fução retorna true
        return true;
    }

    @FXML
    private void inserir(ActionEvent event) {
        /**
         * nesse if a variavel 'edition' serve para decidir se a função é para
         * Inserir ou editar. se for false é para inserir e se for true é para
         * editar
         */
        if(!editMode){
            /**
            * se a fução ValidarProduto retorna false, então não sera executado 
            * nada. 
            */
            if(validarProduto() == false){
                return;
            }
            
            //instanciando 'Produto'
            Produto item = new Produto();
            
            //pegando a digitação do usuario
            item.produto = tfProduto.getText();
            item.cor = tfCor.getText();
            item.marca = tfMarca.getText();
            item.estoque = Integer.parseInt(tfQuantidade.getText());
            item.preco = Double.parseDouble(tfValor.getText());
            
            /**
            * chamando a função que ira inserir no bd passando o 'item'
            * como parametro
            */
        try{
            ItemProdutoDAO.inserir(item);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Inserido com Sucesso");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
            
        }catch(Exception e){
            //caso de um erro sera inviado uma mensagem para o usuario
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Valha ao Inserir");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
        }
            
        }else{
            /**
            * se a fução ValidarProduto retorna false, então não sera executado 
            * nada. 
            */
            if(validarProduto() == false){
                return;
            }
            
            //pegando a digitação do usuario
            itemProdutoEdicao.produto = tfProduto.getText();
            itemProdutoEdicao.cor = tfCor.getText();
            itemProdutoEdicao.marca = tfMarca.getText();
            itemProdutoEdicao.estoque = Integer.parseInt(tfQuantidade.getText());
            itemProdutoEdicao.preco = Double.parseDouble(tfValor.getText());
            
            /**
            * chamando a função que ira editar no bd passando o 'itemProdutoEdicao'
            * como parametro
            */
            
            try {
                ItemProdutoDAO.editar(itemProdutoEdicao);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salvar");
                alert.setHeaderText("Salvo com Sucesso");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
                
            } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Salvar");
                alert.setHeaderText("Valha ao Salvar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            } 
        }
        //função limparCampos e pesquisar é executada
        limparCampos(event);
        pesquisar(event);
        
    }

    @FXML
    private void pesquisar(ActionEvent event) {
        //caso não tenha nada digitado na tfPesquisa sera listado todos os registros
        if(tfPesquisar.getText().equals("")){
            /**
             * no try=catch é criado uma lista com o 'Produto' como parametro 
             * pegando a lista que vem do ProdutoDAO função Listar
             */
            try{
                List<Produto> resultado = ItemProdutoDAO.listar();

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                //caso de um erro sera exibido uma mensagem para o usuario
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisar");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
        }
        else {
            /**
             * caso tenha algo digitado na tfPesquisa sera feito uma consulta. 
             * a lista 'Produto' recebe a lista que vem do ProdutoDAO função pesquisar
             */
            try{
                List<Produto> resultado = ItemProdutoDAO.pesquisar(tfPesquisar.getText());

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
    }

    @FXML
    private void editar(ActionEvent event) {
        //recebera os dados do produto selecionado 
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        //se itemSelecionado for diferente de 'null' então a variavel global
        //recebe true
        if(itemSelecionado != null){
            editMode = true;
            
            //variavel global recebe itemSelecionado
            itemProdutoEdicao = itemSelecionado;
            
            //dados sendo passados para a variavel  itemProdutoEdicao
            tfProduto.setText(itemProdutoEdicao.produto);
            tfCor.setText(itemProdutoEdicao.cor);
            tfMarca.setText(itemProdutoEdicao.marca);
            tfQuantidade.setText(String.valueOf(itemProdutoEdicao.estoque));
            tfValor.setText(String.valueOf(itemProdutoEdicao.preco));            
            
            // botão recebe o nome 'Salvar'
            btnSalvar.setText("Salvar");
        }
    }

    @FXML
    private void excluir(ActionEvent event) {
        //recebera os dados do produto selecionado
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        /**
         * se itemSelecionado for diferente de 'null' então sera exibido para 
         * o usuario uma botão para confirmar ou cancelar. Se o usuario apertar 
         * 'ok' então no try-catch sera chamado a funcão excluir do ProdutoDAO 
         * passando como parametro o id do registro.
         */
        
        if(itemSelecionado != null){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmar Remoção");
            alert.setContentText("Remover o item " + itemSelecionado.produto);
            
            Optional<ButtonType> resultado = alert.showAndWait();
                if(resultado.get() == ButtonType.OK){
                    try {
                    ItemProdutoDAO.excluir(itemSelecionado.id);
                    alert.setTitle("Excluir");
                    alert.setHeaderText("Excluido");
                    alert.setContentText("Click em OK para continuar");
                    alert.showAndWait();

                } catch (Exception e) {
                    e.printStackTrace();
                    alert.setTitle("Excluir");
                    alert.setHeaderText("Valha ao Excluir");
                    alert.setContentText("Click em OK para continuar");
                    alert.showAndWait();
                } 
            }
            //sera executado a função pesquisar
            pesquisar(event);
        }
    }
    
}
