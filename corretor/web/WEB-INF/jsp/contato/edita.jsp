<%-- 
    Document   : edita
    Created on : 27/03/2013, 11:36:35
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<div class="principal">
    <h1 class="principal">Edição de Contato</h1>
    <c:if test="${empty clientecontato}">
        <h3 class="mensagem">Um erro ocorreu</h3>
    </c:if>
    <c:if test="${not empty clientecontato}">
        <form class="principal" action="<c:url value="/contato/${clientecontato.id }"/>" method="POST">
            <input style="visibility: hidden" id="id" type="text" name="clienteContato.idclienteId.id" value="${clientecontato.idclienteId.id}"/>
            <fieldset>
                <legend><h3>Editar Contato</h3></legend>
                <table class="cadastro"  >
                    <tr>
                        <td class="cadastro">
                            <label class="cadastro" for="nome">${clientecontato.idclienteId.nome}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label for="produtointeresse">${clientecontato.idclienteId.produtointeresse}</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label for="descricao">Tipo:</label>
                        </td>
                        <td>
                            <input id="siglatipo" type="text" name="clienteContato.siglatipo"
                                   value="${clientecontato.siglatipo}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label for="preco">Tipo Contato:</label>
                        </td>
                        <td>
                            <input id="siglatipocontato" type="text" name="clienteContato.siglatipocontato"
                                   value="${clientecontato.siglatipocontato}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="cadastro">
                            <label for="preco">Descrição Contato:</label>
                        </td>
                        <td>
                            <input id="desccontato" type="text" name="clienteContato.desccontato"
                                   value="${clientecontato.desccontato}"/>
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
