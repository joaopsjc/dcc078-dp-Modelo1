/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;

/**
 *
 * @author joaopsjc
 */
public class EmpresaDAO {
/**
 * DAO = data access object
 */
    private static EmpresaDAO instance = new EmpresaDAO();
    public static EmpresaDAO getInstance()
    {
        return instance;
    }
    
    public void save(Empresa empresa) throws SQLException,ClassNotFoundException
    {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into empresa (nome)" +
                       " values ('" + empresa.getNome() + "')");
        } catch (SQLException e) {
            throw e;
        } 
        finally
        {
            closeResources(conn,st);
        }
    }
    public void delete(Empresa empresa) throws SQLException,ClassNotFoundException
    {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("DELETE FROM empresa WHERE empresa.nome = '" + empresa.getNome() + "'");
        } catch (SQLException e) {
            throw e;
        } 
        finally
        {
            closeResources(conn,st);
        }
    }
    public List<Empresa> readAll() throws SQLException,ClassNotFoundException
    {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            
            List<Empresa> empresas = new ArrayList<Empresa>();
            
            String query = "select * from empresa";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                Empresa empresa = new Empresa(rs.getString("nome"));
            }
            
            return empresas;
            
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
