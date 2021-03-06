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
import model.Carrinho;
import model.ConnectionFactory;
import model.Fisico;
import model.Juridico;
import model.Pessoa;

/**
 *
 * @author cesardias
 */
public class CarrinhoDAO {

    public void insereNoCarrinho(Carrinho carrinho) throws SQLException {

        String sql = "INSERT INTO `CARRINHO` (`ID_PRODUTO`, `ID_PESSOA`, `QUANTIDADE` ) VALUES (?,?,?)";

        try (Connection conexao = ConnectionFactory.connect();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, carrinho.getId_produto());
            ps.setInt(2, carrinho.getId_pessoa());
            ps.setInt(3, carrinho.getQtd_produto());
            ps.executeUpdate();
            /*conexao.commit();*/
        } catch (SQLException ex) {
            Logger.getLogger(ex.toString());
        }
    }

    public List<Carrinho> buscarNoCarrinho() {
        try {
            Connection conexao = ConnectionFactory.connect();
            PreparedStatement ps = conexao.prepareStatement("SELECT ID_PRODUTO, ID_PESSOA, QUANTIDADE FROM CARRINHO ORDER BY id DESC LIMIT 1");
            ResultSet resultSet = ps.executeQuery();
            List<Carrinho> carrinhos = new ArrayList<>();
            while (resultSet.next()) {
                Carrinho carrinho = new Carrinho();
                carrinho.setId(resultSet.getInt("ID"));
                carrinho.setId_pessoa(resultSet.getInt("ID_PESSOA"));
                carrinho.setId_produto(resultSet.getInt("ID_PRODUTO"));
                carrinho.setQtd_produto(resultSet.getInt("QUANTIDADE"));

                carrinhos.add(carrinho);

            }
            return carrinhos;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
