package model;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 
/**
 *
 * @author cesardias
 */
public class ConnectionFactory {
    
   private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:sqlite:/Users/cesardias/Documents/Pulse.db";
    private static final String USUARIO = null;
    private static final String SENHA = null; 
    
    public static Connection connect() {
        if(conexao == null){
            try {
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao(){
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}