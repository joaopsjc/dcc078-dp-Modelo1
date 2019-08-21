/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import model.Contato;

/**
 *
 * @author joaopsjc
 */
public class ContatoDAO {
/**
 * DAO = data access object
 */
    private static ContatoDAO instance = new ContatoDAO();
    public static ContatoDAO getInstance()
    {
        return instance;
    }
    
    public void save(Contato contato) throws SQLException,ClassNotFoundException
    {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into contato (nome, email)" +
                       " values ('" + contato.getNome() + "', '" + contato.getEmail() + "')");
        } catch (SQLException e) {
            throw e;
        } 
        finally
        {
            closeResources(conn,st);
        }
    }
    public void delete(Contato contato) throws SQLException,ClassNotFoundException
    {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM contato WHERE " +
                       " contato.nome = '" + contato.getNome() +  "' AND " + " contato.email = '" + contato.getEmail() +"'");
        } catch (SQLException e) {
            throw e;
        } 
        finally
        {
            closeResources(conn,st);
        }
    }
    public void read(Contato contato) throws SQLException,ClassNotFoundException
    {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            st.execute("select email from contato where " +
                       " contato.nome = '" + contato.getNome() +  "'");
        } catch (SQLException e) {
            throw e;
        } 
        finally
        {
            closeResources(conn,st);
        }
    }

    private void closeResources(Connection conn, Statement st) {
        try {
                    if(st!=null) st.close();
                    if(conn!=null) conn.close();
                    
                } catch(SQLException e) {
                    
                }
    }
}
