/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author cesardias
 */
public class Juridico extends Pessoa{

    /**
     * @return the qtd_funcionarios
     */
    public int getQtd_funcionarios() {
        return qtd_funcionarios;
    }

    /**
     * @param qtd_funcionarios the qtd_funcionarios to set
     */
    public void setQtd_funcionarios(int qtd_funcionarios) {
        this.qtd_funcionarios = qtd_funcionarios;
    }

    /**
     * @return the qtd_filiais
     */
    public int getQtd_filiais() {
        return qtd_filiais;
    }

    /**
     * @param qtd_filiais the qtd_filiais to set
     */
    public void setQtd_filiais(int qtd_filiais) {
        this.qtd_filiais = qtd_filiais;
    }

    /**
     * @return the cnpj
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }
    private int cnpj;
    private int qtd_funcionarios;
    private int qtd_filiais;
    
}
