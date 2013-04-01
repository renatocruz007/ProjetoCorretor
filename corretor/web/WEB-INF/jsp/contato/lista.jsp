<%-- 
    Document   : lista
    Created on : 23/03/2013, 18:49:43
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<h1>Lista de Contatos</h1>
<c:if test="${empty clientecontatoList}">
    O cliente não possui contatos cadastrados!
</c:if>
<c:if test="${not empty clientecontatoList}">
    <table>
        <input style="visibility: hidden" id="id" type="text" name="cliente.id" value="${cliente.id}"/>
        <thead>
            <tr>
                <th>Tipo</th>
                <th>Tipo contato</th>
                <th>Descrição</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clientecontatoList}" var="contato" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
                    <td>${contato.siglatipo}</td>
                    <td>${contato.siglatipocontato }</td>
                    <td>${contato.desccontato }</td>
                    <td><a href="<c:url value="/contato/edita/${contato.id}"/>">
                            Editar
                        </a></td>
                    <td>
                        <form action="<c:url value="/contato/${contato.id}"/>"
                              method="POST">
                            <button class="link" name="_method" value="DELETE">
                                Remover
                            </button>
                        </form>
                    </td>
                    <td><a href="<c:url value="/contato/${contato.idclienteId.id}"/>">
                            Adicionar contato
                        </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
