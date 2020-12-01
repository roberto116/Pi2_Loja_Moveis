
package br.senac.LojaMoveis.bd;
import br.senac.LojaMoveis.registros.Cliente;
import br.senac.LojaMoveis.registros.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author lenovo
 */
public class CadastroClientesDAO {
        public static void inserir(Cliente item)throws Exception{
        String sql = "INSERT INTO cliente (nome, sobrenome, cpf, datanascimento, email, telefone, celular) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        Connection conexao = ConnectionUtils.getConnection();
        
        try{
            PreparedStatement comando = conexao.prepareStatement(sql);
            
            comando.setString(1, item.nome);
            comando.setString(2, item.sobrenome);
            comando.setInt(3, item.cpf);
            comando.setDouble(4, item.datanascimento);
            comando.setString(5, item.email);
            comando.execute();
            
        }finally{
            conexao.close();
        }
    }
    
}
