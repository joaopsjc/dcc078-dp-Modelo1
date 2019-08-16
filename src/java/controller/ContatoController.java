/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;
import persistence.ContatoDAO;

/**
 *
 * @author ice
 */
public class ContatoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String nome = request.getParameter("textNome");
        String email = request.getParameter("textEmail");
        
        if(nome.equals("") || email.equals("")) {
        
           response.sendRedirect("ContatoErro.jsp");
        
        } else {
            try{
                Contato contato = new Contato(nome,email);
                ContatoDAO.getInstance().save(contato);
                response.sendRedirect("ContatoSucesso.jsp");
            }
            catch(SQLException ex)
            {
                response.sendRedirect("ContatoErro.jsp");
                ex.printStackTrace();
            }
        
          
        
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            processRequest(request, response);
        }
        catch(ServletException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            processRequest(request, response);
        }
        catch(ServletException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}