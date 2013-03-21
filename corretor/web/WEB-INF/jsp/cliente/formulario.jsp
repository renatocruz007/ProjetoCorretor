<%-- 
    Document   : formulario
    Created on : 28/08/2012, 01:05:36
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
        <c:import url="/WEB-INF/jsp/home/cabecalho.jsp" />
        <h1></h1>
        <form action="adiciona">
            <fieldset>
                <legend>Adicionar Cliente</legend>
                <input id="id" type="text" name="cliente.id"/>
                
                <label for="nome">Nome:</label>
                <input id="nome" type="text" name="cliente.nome"/>
                
                <label for="descricao">Tipo:</label>
                <input id="descricao" type="text" name="clienteContato.siglaTipo"/>
                
                <label for="preco">Tipo Contato:</label>
                <input id="preco" type="text" name="clienteContato.siglaTipocontato"/>
                
                <label for="preco">Desc Contato:</label>
                <textarea id="descricao" name="clienteContato.descContato"></textarea>
                
                <button type="submit">Enviar</button>
            </fieldset>
        </form>
    </body>
</html>
