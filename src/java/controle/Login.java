/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;


import javax.faces.bean.ManagedBean;

/**
 *
 * @author cesardias
 */
@ManagedBean
public class Login {
    
    
 private String login;
    private String senha;
    private String message;
    
    public String validaLogin() {
        if (getLogin().equals("admin")) {
            if (getSenha().equals("admin")) {setMessage("Bem vindo " + getLogin() + "a Pulse!");}
            else {
                setMessage("Senha Invalida");
        }
        } else {
            setMessage("Usuario nao Encontrado !");
        }
        
    return null;
    }
    
    
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
   
    
}
