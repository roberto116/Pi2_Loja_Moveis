/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.LojaMoveis.telas;
import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.registros.Produto;
import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import br.senac.LojaMoveis.bd.ClienteDAO;
import br.senac.LojaMoveis.bd.ItemProdutoDAO;
import br.senac.LojaMoveis.bd.ItemVendaDAO;
import br.senac.LojaMoveis.bd.ItemVendas_ProdutosDAO;
import br.senac.LojaMoveis.registros.Cliente;
import br.senac.LojaMoveis.registros.Produto;
import br.senac.LojaMoveis.registros.Vendas;
import br.senac.LojaMoveis.registros.Vendas_Produtos;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class TelaVendaController implements Initializable {

    @FXML
    private TextField tfQtd;
    @FXML
    private TextField tfValorTotal;
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
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn<Cliente, String> colunaNome;
    @FXML
    private TableColumn<Cliente, String> colunaSobrenome;
    @FXML
    private TextField tfPesquisarProd;
    @FXML
    private TextField tfPesquisaCliente;
    @FXML
    private Button Carrinho;
    @FXML
    private Label tfCarrinho;
    @FXML
    private DatePicker dtData;
    @FXML
    private TableColumn<Cliente, Integer> colunaIdClien;
    @FXML
    private TableColumn<Produto, Integer> colunaIdProd;
    
    List<Vendas_Produtos> carrinho = new ArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         /**
         * está sendo inicializado assim que abri a tela de vendas
         * todas as colunas das tabelas
         */
        
        colunaIdProd.setCellValueFactory(new PropertyValueFactory("id"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory("produto"));
        colunaCor.setCellValueFactory(new PropertyValueFactory("cor"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory("estoque"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("preco"));
        
        colunaIdClien.setCellValueFactory(new PropertyValueFactory("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaSobrenome.setCellValueFactory(new PropertyValueFactory("sobrenome"));
        
        LocalDate hoje = LocalDate.now();
        dtData.setValue(hoje);
    }    

    @FXML
    private void finalizar(ActionEvent event) {
            //instanciando 'Vendas'
            Vendas venda = new Vendas();
            
            //recebera os dados do produto selecionado 
            Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
            
            //recebera os dados do cliente selecionado 
            Cliente clienSelecionado = tabelaCliente.getSelectionModel().getSelectedItem();
            
            //variavel que guarda o id do cliente selecionado
            int idclint = clienSelecionado.id;
            
            //pegando data da venda e o id do cliente 
            LocalDate dataDigitada = dtData.getValue();
            venda.datavenda = Date.valueOf(dataDigitada);            
            venda.idcliente = idclint;   
            
      try{
            /**
             * aqui é guardado o 'id' da venda e inserido no bd com a função do
             * ItemVendaDAO
             */
            int idVenda = ItemVendaDAO.inserirVendas(venda);
            
            for(int i = 0; i < carrinho.size();i++)
            {
                /**
                 * nessa linha é onde é inserido os dados nessesarios da tabela
                 * vendas_produtos com o id da venda
                 */ 
                ItemVendas_ProdutosDAO.inserirVendasProdutos(carrinho.get(i),idVenda);
            }
        
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Inserido com Sucesso");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
            
        }catch(Exception e){
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Inserir");
            alert.setHeaderText("Falha ao Inserir");
            alert.setContentText("Click em OK para continuar");
            alert.showAndWait();
        }
    }

    @FXML
    private void calcular(ActionEvent event)
    {
        //recebera os dados do produto selecionado 
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        //o valor digitado no tfQtd é quardado na variavel valor
        int valor = Integer.parseInt(tfQtd.getText());
        
        //se valor for menor que o preco do item selecionado e valor for maior que 0
        if(valor < itemSelecionado.preco && valor > 0)
        {
            //calc recebe o valor do produto e é mostrado na tfValorTotal 
            try{
                double Calc = itemSelecionado.preco * valor;
        
                String CalcTotal = "" + Calc;
        
                tfValorTotal.setText(CalcTotal);
            }
            catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Calcular");
                alert.setHeaderText("Falha no Calculo,Tente Novamente");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
        else
        {
            //mensagens de erro 
            try{
             Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Calcular");
                alert.setHeaderText("Quantidade Invalida,Verifique o estoque");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }
             catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Calcular");
                alert.setHeaderText("Falha no Calculo,Tente Novamente");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
    }

    @FXML
    private void pesquisarProd(ActionEvent event) 
    {
        //caso não tenha nada digitado na tfPesquisa sera listado todos os registros
          if(tfPesquisarProd.getText().equals("")){
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
                List<Produto> resultado = ItemProdutoDAO.pesquisar(tfPesquisarProd.getText());

                tabelaProduto.setItems(FXCollections.observableArrayList(resultado));
                tabelaProduto.refresh();
                
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        } 
    }

    @FXML
    private void pesquisarClie(ActionEvent event) 
    {
        //caso não tenha nada digitado na tfPesquisa sera listado todos os registros
           if(tfPesquisaCliente.getText().equals("")){
             /**
             * no try=catch é criado uma lista com o 'Cliente' como parametro 
             * pegando a lista que vem do ClienteDAO função Listar
             */
            try{
                List<Cliente> resultado = ClienteDAO.listar();

                tabelaCliente.setItems(FXCollections.observableArrayList(resultado));
                tabelaCliente.refresh();
                
            }catch(Exception e){
                //caso de um erro sera exibido uma mensagem para o usuario
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
             * a lista 'cliente' recebe a lista que vem do ClienteDAO função pesquisar
             */
            try{
                List<Cliente> resultado = ClienteDAO.pesquisar(tfPesquisaCliente.getText());

                tabelaCliente.setItems(FXCollections.observableArrayList(resultado));
                tabelaCliente.refresh();
                
            }catch(Exception e){
                //caso de um erro sera inviado uma mensagem para o usuario
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Pesquisar");
                alert.setHeaderText("Falha ao Pesquisa");
                alert.setContentText("Click em OK para continuar");
                alert.showAndWait();
            }  
        }
    }

    @FXML
    private void Carrinho(ActionEvent event) 
    {
        //recebera os dados do produto selecionado 
        Produto itemSelecionado = tabelaProduto.getSelectionModel().getSelectedItem();
        
        //variavel que recebe o nome do produto
        String Prod = itemSelecionado.produto;
        
        //instanciando Vendas_Produtos e pegando os campos necessarios
            Vendas_Produtos item = new Vendas_Produtos();
                item.idProduto = itemSelecionado.id;
                item.quantidade = Integer.parseInt(tfQtd.getText());
                item.total = Double.parseDouble(tfValorTotal.getText());                            
        //adicionando na lista 'carrinho' o registro com o 'item' como parametro
        carrinho.add(item);
        
        //variavel adicionar recebe 'Prod'
        String Adicionar = "" + Prod;
        
        tfCarrinho.setText(tfCarrinho.getText()+ ", " + Adicionar);
               
       
    }
        
        
    
       
}
    

   
    
    

