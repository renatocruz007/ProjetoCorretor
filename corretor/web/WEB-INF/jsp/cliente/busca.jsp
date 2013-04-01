<%-- 
    Document   : busca
    Created on : 01/04/2013, 16:06:27
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<h3>Resultados da busca pelo nome <b>"${nome }"</b></h3>
<c:if test="${empty clienteList}">
    Não há clientes com esse nome na agenda!
</c:if>
<c:if test="${not empty clienteList}">
    <table>
        <thead>
            <tr>
                <th>Nome</th>
                <th>Nome conjugue</th>
                <th>Origem</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${clienteList}" var="cliente" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
                    <td>${cliente.nome }</td>
                    <td>${cliente.nomeconjugue }</td>
                    <td>${cliente.origem }</td>
                    <td><a href="<c:url value="/cliente/${cliente.id}"/>">
                            Editar
                        </a></td>
                    <td>
                        <form action="<c:url value="/cliente/remove/${cliente.id}"/>"
                              method="POST">
                            <button class="link" name="_method" value="DELETE">
                                Remover
                            </button>
                        </form>
                    </td>
                    <td><a href="<c:url value="/contato/lista/${cliente.id}"/>">
                            Listar contatos
                        </a></td>
                    <td><a href="<c:url value="/contato/${cliente.id}"/>">
                            Adicionar contato
                        </a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
