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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author ice
 */
public class LerTodasEmpresasAction implements Action{
    public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException
    {             
        try{
            List<Empresa> empresas = null;
            empresas = EmpresaDAO.getInstance().readAll();
        }
        catch(SQLException ex)
        {
            response.sendRedirect("OperacaoErro.jsp");
            ex.printStackTrace();
        }
        
    }
}
