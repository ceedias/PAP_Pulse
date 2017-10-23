/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Pessoa;
import controle.PessoaBean;

/**
 *
 * @author cesardias
 */
@ManagedBean
@SessionScoped
public class LoginBean extends PessoaBean{

    /**
     * @return the dao
     */
    public LoginDAO getDao() {
        return dao;
    }

    /**
     * @param dao the dao to set
     */
    public void setDao(LoginDAO dao) {
        this.dao = dao;
    }
    
    private LoginDAO dao = new LoginDAO();
    
  
    
    public String verificaLogin() throws SQLException{

        
        if (getDao().verificaLogin(getPessoa()) == false){
                FacesContext.getCurrentInstance().addMessage("growl",
                       new FacesMessage("Não autorizado", "Nenhum registro foi encontrado com essas informações"));
                             return null;

        } else {
                return vaiParaIndex();
        }                  
        
    }   
         
    public String vaiParaIndex() {
        return "/view/index?faces-redirect=true";
    }
    
}
