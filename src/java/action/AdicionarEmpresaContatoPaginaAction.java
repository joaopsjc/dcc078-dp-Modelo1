/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import controller.Action;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author ice
 */
public class AdicionarEmpresaContatoPaginaAction implements Action{
    public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException
    {

        try {
            List<Empresa> empresas = EmpresaDAO.getInstance().readAll();
            request.setAttribute("empresas", empresas);
            RequestDispatcher view = request.getRequestDispatcher("AdicionarEmpresaContato.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(AdicionarEmpresaContatoPaginaAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarEmpresaContatoPaginaAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
