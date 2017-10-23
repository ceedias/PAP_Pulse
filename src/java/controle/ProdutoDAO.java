/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ConnectionFactory;
import model.Fisico;
import model.Juridico;
import model.Produto;
import controle.ProdutoBean;

/**
 *
 * @author cesardias
 */
public class ProdutoDAO {
 public void salvar (Produto produto) throws SQLException{

        String sql = "INSERT INTO `PRODUTO` (`NOME`, `DESCRICAO`, `QUANTIDADE`) VALUES (?,?,?)";

        try (Connection conexao = ConnectionFactory.connect();
       
        PreparedStatement ps = conexao.prepareStatement(sql)){
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQtd());
            ps.executeUpdate();
            /*conexao.commit();*/
        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
    }
    
    public List<Produto> buscar(){
        try {
            Connection conexao = ConnectionFactory.connect();
            PreparedStatement ps = conexao.prepareStatement("select * from produto");
            ResultSet resultSet = ps.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            while(resultSet.next()){
                Produto produto = new Produto();
                produto.setId(resultSet.getInt("ID"));
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("DESCRICAO"));
                produto.setQtd(resultSet.getInt("QUANTIDADE"));
                
                produtos.add(produto);
                
            }
            return produtos;
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }   
}
