<%-- 
    Document   : ContatoLeitura
    Created on : 20/08/2019, 22:52:31
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div>
        <h1>Visualização de Email do Contato</h1>
        <form action="FrontController?action=LerContato&contato=<c:out value="${contato}"/>" method="post">
          Entre com seu nome
          <input type="text" name="textNome"/><br/>
          <input type="submit"/>
        </form>
    </div>
        <div>
            seu e-mail é:    
               <span><c:out value="${contato}"/></span>
        </div>
    </body>
</html>
