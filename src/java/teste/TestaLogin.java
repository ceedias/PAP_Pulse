/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import controle.LoginDAO;
import model.Pessoa;

/**
 *
 * @author cesardias
 */
public class TestaLogin{

    public static void main(String[] args) {
    Pessoa pessoa = new Pessoa();
    LoginDAO dao = new LoginDAO();

    pessoa.setLogin("CESAR");
    pessoa.setSenha("CESAR");
    
    if (dao.verificaLogin (pessoa) ){
       
                  System.out.println("OK");;
        }
        else {

    
           System.out.println("NOK");
    }
}
}
