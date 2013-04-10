<%-- 
    Document   : formulario
    Created on : 28/08/2012, 01:05:36
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<div class="principal">
    <h1 class="principal">Adição de Histórico</h1>
    <form class="principal" action="<c:url value="/historico"/>" method="POST">
        <fieldset>
            <legend><h3>Formulário de histórico</h3></legend>
            <table class="cadastro"  >
                <input style="visibility: hidden" id="id" type="text" name="cliente.id" value="${cliente.id}"/>
                <tr>
                        <td class="cadastro">
                            <label class="cadastro" for="nome">Nome:</label>
                        </td>
                        <td class="cadastro">
                            <label class="cadastro" for="nome">${cliente.nome}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label class="cadastro" for="produtointeresse">Produto de interesse:</label>
                        </td>
                        <td class="cadastro">
                            <label for="produtointeresse">${cliente.produtointeresse}</label>
                        </td>
                    </tr>
                <tr>
                    <td class="cadastro">
                        <label for="descricao">Descrição:</label>
                    </td>
                    <td>
                        <textarea cols=30 rows="4" id="descricao" name="historico.descricao"></textarea>
                    </td>
                </tr>
            </table>
            <button type="submit">Enviar</button>
        </fieldset>
    </form>
</div>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
