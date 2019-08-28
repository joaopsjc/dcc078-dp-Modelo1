<%-- 
    Document   : ContatoLeitura
    Created on : 20/08/2019, 22:52:31
    Author     : ice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div>
        <h1>Visualização de Email do Contato</h1>
        <form action="FrontController?action=LerContato" method="post">
          Entre com seu nome
          <input type="text" name="textNome"/><br/>
          <input type="submit"/>
        </form>
    </div>
    </body>
</html>
