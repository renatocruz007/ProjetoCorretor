<%-- 
    Document   : edita
    Created on : 27/03/2013, 11:36:35
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<div class="principal">
    <h1 class="principal">Edição de Histórico</h1>
    <c:if test="${empty historico}">
        <h3 class="mensagem">Um erro ocorreu</h3>
    </c:if>
    <c:if test="${not empty historico}">
        <form class="principal" action="<c:url value="/historico/${historico.id }"/>" method="POST">
            <input style="visibility: hidden" id="id" type="text" name="historico.idclienteId.id" value="${historico.idclienteId.id}"/> 
            <input style="visibility: hidden" id="data" type="text" name="historico.data.time" value="<fmt:formatDate value="${historico.data.time}"
                                            pattern="dd/MM/yyyy" />"/>
            <fieldset>
                <legend><h3>Editar Histórico</h3></legend>
                <table class="cadastro"  >
                    <tr>
                        <td class="cadastro">
                            <label class="cadastro" for="nome">Nome:</label>
                        </td>
                        <td class="cadastro">
                            <label class="cadastro" for="nome">${historico.idclienteId.nome}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label class="cadastro" for="produtointeresse">Produto de interesse:</label>
                        </td>
                        <td class="cadastro">
                            <label for="produtointeresse">${historico.idclienteId.produtointeresse}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label class="cadastro" for="data">Data:</label>
                        </td>
                        <td class="cadastro">
                            <fmt:formatDate value="${historico.data.time}"
                                            pattern="dd/MM/yyyy" />             
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label for="descricao">Descrição:</label>
                        </td>
                        <td>
                            <textarea  cols=30 rows="4" id="descricao" name="historico.descricao"
                                      >${historico.descricao}</textarea>
                        </td>
                    </tr>
                </table>
                <button type="submit" name="_method" value="PUT">
                    Enviar
                </button>
            </fieldset>
        </form>
    </c:if>
</div>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
