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
public class Fisico extends Pessoa{

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @param qtd_filhos the qtd_filhos to set
     */
    public void setQtd_filhos(int qtd_filhos) {
        this.qtd_filhos = qtd_filhos;
    }

    /**
     * @param qtd_cigarros the qtd_cigarros to set
     */
    public void setQtd_cigarros(int qtd_cigarros) {
        this.qtd_cigarros = qtd_cigarros;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the qtd_filhos
     */
  
public int getQtd_filhos() {
        return qtd_filhos;
    }
    /**
     * @param qtd_filhos the qtd_filhos to set
     */
    public void setQtd_filhos(String qtd_filhos) {
        this.setQtd_filhos(qtd_filhos);
    }

    /**
     * @return the qtd_cigarros
     */
    public int getQtd_cigarros() {
        return qtd_cigarros;
    }

    /**
     * @param qtd_cigarros the qtd_cigarros to set
     */
    public void setQtd_cigarros(String qtd_cigarros) {
        this.setQtd_cigarros(qtd_cigarros);
    }
    private String CPF;
    private int qtd_filhos;
    private int qtd_cigarros;
    private String sexo;
}
