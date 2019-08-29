/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import persistence.ContatoDAO;

/**
 *
 * @author joaopsjc
 */
public class Contato {
    private String nome;
    private String email;    
    private String nomeEmpresa;
            
    public Contato() {
    }

    public Contato(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.nomeEmpresa = null;
    }

    public Contato(String nome, String email, String nomeEmpresa) {
        this.nome = nome;
        this.email = email;
        this.nomeEmpresa = nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
    public void gravar()
    {}
    public void alterar()
    {}
    public void excluir()
    {}

    public static Contato obterCurso(String nome) throws ClassNotFoundException, SQLException {
        return ContatoDAO.getInstance().read(nome);
    }
}
