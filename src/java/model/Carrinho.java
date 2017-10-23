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
public class Carrinho {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id_pessoa
     */
    public int getId_pessoa() {
        return id_pessoa;
    }

    /**
     * @param id_pessoa the id_pessoa to set
     */
    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the qtd_produto
     */
    public int getQtd_produto() {
        return qtd_produto;
    }

    /**
     * @param qtd_produto the qtd_produto to set
     */
    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }
    
    private int id;
    private int id_pessoa;
    private int id_produto;
    private int qtd_produto;
    
}
