/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.List;
import persistence.EmpresaDAO;

/**
 *
 * @author John
 */
public class Empresa {
    private String nome;

    public Empresa() {
    }

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void gravar()
    {}
    public void alterar()
    {}
    public void excluir()
    {}

    public static List<Empresa> obterCursos() throws ClassNotFoundException, SQLException {
        return EmpresaDAO.getInstance().readAll();
    }
}
