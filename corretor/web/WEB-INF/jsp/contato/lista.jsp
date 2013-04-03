<%-- 
    Document   : lista
    Created on : 23/03/2013, 18:49:43
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<div class="principal">
    <h1 class="principal">Lista de Contatos</h1>
    <c:if test="${not empty erro}">
        <h3 class="mensagem">${erro}</h3>
    </c:if>
    <c:if test="${empty erro}">
        <c:if test="${empty clientecontatoList}">
            <h3 class="mensagem" >O cliente não possui contatos cadastrados!</h3>
        </c:if>
        <c:if test="${not empty clientecontatoList}">
            <table class="lista">
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
                        <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ccc' }">
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
    </c:if>
</div>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
