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
import model.Empresa;
import persistence.EmpresaDAO;

/**
 *
 * @author ice
 */
public class ApagarEmpresaAction implements Action{
    public void execute (HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException
    {
        String nome = request.getParameter("textNome");
        
        if(nome.equals("")) {
        
           response.sendRedirect("OperacaoErro.jsp");
        
        } else {
            try{
                Empresa empresa = new Empresa(nome);
                EmpresaDAO.getInstance().delete(empresa);
                response.sendRedirect("OperacaoSucesso.jsp");
            }
            catch(SQLException ex)
            {
                response.sendRedirect("OperacaoErro.jsp");
                ex.printStackTrace();
            }
        
        }
    }
}
