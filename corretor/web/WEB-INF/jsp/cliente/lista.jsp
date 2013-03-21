<%-- 
    Document   : lista
    Created on : 28/08/2012, 00:43:15
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Nome conjugue</th>
                    <th>Origem</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${clienteList}" var="cliente">
                    <tr>
                        <td>${cliente.nome }</td>
                        <td>${cliente.nomeconjugue }</td>
                        <td>${cliente.origem }</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
