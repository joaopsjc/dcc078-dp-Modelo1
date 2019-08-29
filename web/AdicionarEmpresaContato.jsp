<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Adicionar Empresa a Contato</h1>
            <select>
                <c:forEach items="${empresas}" var="empresa">
                    <option><c:out value="${empresa.getNome()}" /></option>
                </c:forEach>
            </select>
            <form method="post" action=" FrontController?action=AdicionarEmpresaContato&nomeEmpresa=<c:out value="${empresa.getNome()}"/>">
                Entre com seu nome
                <input type="text" name="textNome"/><br/>
                <input type="submit"/>
            </form>

        </div>
    </body>
</html>