/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        
           response.sendRedirect("OperacaoErro.jsp");
        
        } else {
            try{
                
                Contato contato = null;
                contato = ContatoDAO.getInstance().read(nome);
                request.setAttribute("contato", contato.getEmail());
                RequestDispatcher view = request.getRequestDispatcher("LerContato.jsp");
                view.forward(request, response);
                
            }
            catch(SQLException ex)
            {
                response.sendRedirect("OperacaoErro.jsp");
                ex.printStackTrace();
            } catch (ServletException ex) {
                Logger.getLogger(LerContatoAction.class.getName()).log(Level.SEVERE, null, ex);
                response.sendRedirect("OperacaoErro.jsp");
            }
        
        }
    }
}
