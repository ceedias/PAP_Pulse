/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import com.sun.faces.action.RequestMapping;
import static com.sun.faces.el.FacesCompositeELResolver.ELResolverChainType.Faces;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Pessoa;
import java.sql.SQLException;
import java.util.Base64;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fisico;
import model.Juridico;


/**
 *
 * @author cesardias
 */
@ManagedBean
@SessionScoped
@RequestMapping ("/login.xhtml")
public class PessoaBean {

    private Pessoa pessoa = new Pessoa();
    private Juridico juridico = new Juridico();
    private Fisico fisico = new Fisico();
    private List<Pessoa> pessoas = new ArrayList<>();
    private List<Fisico> fisicos = new ArrayList<>();
    private List<Juridico> juridicos = new ArrayList<>();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private LoginDAO dao = new LoginDAO();

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

    /**
     * @return the fisicos
     */
    public List<Fisico> getFisicos() {
        return fisicos;
    }

    /**
     * @param fisicos the fisicos to set
     */
    public void setFisicos(List<Fisico> fisicos) {
        this.fisicos = fisicos;
    }

    /**
     * @return the juridicos
     */
    public List<Juridico> getJuridicos() {
        return juridicos;
    }

    /**
     * @param juridicos the juridicos to set
     */
    public void setJuridicos(List<Juridico> juridicos) {
        this.juridicos = juridicos;
    }

    public void adicionar() throws SQLException {
        getPessoas().add(getPessoa());

        pessoaDAO.salvar(pessoa, fisico, juridico);
        setPessoa(new Pessoa());
        FacesContext.getCurrentInstance().addMessage("growl",
                    new FacesMessage("Cliente Cadastrado", "Agora voce poderá acessr nosso painel de login e realizar suas compras!"));
    }

    public void listar() throws SQLException {
        pessoas = pessoaDAO.buscar();
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    /**
     * @return the juridico
     */
    public Juridico getJuridico() {
        return juridico;
    }

    /**
     * @param juridico the juridico to set
     */
    public void setJuridico(Juridico juridico) {
        this.juridico = juridico;
    }

    /**
     * @return the fisico
     */
    public Fisico getFisico() {
        return fisico;
    }

    /**
     * @param fisico the fisico to set
     */
    public void setFisico(Fisico fisico) {
        this.fisico = fisico;
    }

    /**
     * @return the pessoas
     */
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    /**
     * @param pessoas the pessoas to set
     */
    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public String verificaLogin() throws SQLException {

        if (getDao().verificaLogin(getPessoa())) {
            
           FacesContext context = FacesContext.getCurrentInstance();
           Cookie usuario = new Cookie("usuario",pessoa.getLogin());
           
           byte[] encodedBytes = Base64.getEncoder().encode(pessoa.getSenha().getBytes());
           String senhaCriptografada = new String(encodedBytes);
           
           Cookie senha = new Cookie("senha", senhaCriptografada);
 
           Cookie logado = new Cookie("logado","true");
           
           ((HttpServletResponse)context.getExternalContext().getResponse()).addCookie(usuario);
           ((HttpServletResponse)context.getExternalContext().getResponse()).addCookie(senha);
           ((HttpServletResponse)context.getExternalContext().getResponse()).addCookie(logado);
            
            return vaiParaIndex();
                     
        } else {
            FacesContext.getCurrentInstance().addMessage("growl",
                    new FacesMessage("Não autorizado", "Nenhum registro foi encontrado com essas informações"));
            return null;
        }

    }

    public String vaiParaIndex() {
        return "/view/indexLogon?faces-redirect=true";
    }
    

}
