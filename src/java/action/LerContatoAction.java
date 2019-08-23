/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author ice
 */
public class LerContatoAction implements Action{
    public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException
    {
        String nome = request.getParameter("textNome");
        
        if(nome.equals("") || nome == null) {
        
           response.sendRedirect("ContatoErro.jsp");
        
        } else {
            try{
                Contato contato = null;
                
                contato = ContatoDAO.getInstance().read(nome);
            }
            catch(SQLException ex)
            {
                response.sendRedirect("ContatoErro.jsp");
                ex.printStackTrace();
            }
        
        }
    }
}
