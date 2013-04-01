<%-- 
    Document   : formulario
    Created on : 28/08/2012, 01:05:36
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<h1>Adição de contato</h1>
<form action="<c:url value="/contato"/>" method="POST">
    <fieldset>
        <legend>Formulário de contato</legend>
        <table class="cadastro"  >
            <input style="visibility: hidden" id="id" type="text" name="cliente.id" value="${cliente.id}"/>
            <tr>
                <td class="cadastro">
                    <label for="nome">${cliente.nome}</label>
                </td>
            </tr>
            <tr>
                <td class="cadastro">
                    <label for="produtointeresse">${cliente.produtointeresse}</label>
                </td>
            </tr>
            <tr>
                <td class="cadastro">
                    <label for="descricao">Tipo:</label>
                </td>
                <td>
                    <input id="descricao" type="text" name="clienteContato.siglatipo"/>
                </td>
            </tr>
            <tr>
                <td class="cadastro">
                    <label for="preco">Tipo Contato:</label>
                </td>
                <td>
                    <input id="preco" type="text" name="clienteContato.siglatipocontato"/>
                </td>
            </tr>
            <tr>
                <td class="cadastro">
                    <label for="preco">Descrição Contato:</label>
                </td>
                <td>
                    <input id="descricao" type="text" name="clienteContato.desccontato"></input>
                </td>
            </tr>
        </table>
        <button type="submit">Enviar</button>
    </fieldset>
</form>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
