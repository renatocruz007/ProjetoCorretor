<%-- 
    Document   : lista
    Created on : 28/08/2012, 00:43:15
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<div class="principal">
    <h1 class="principal" >Lista de Clientes</h1>
    <c:if test="${not empty erro}">
        <h3 class="mensagem" >${erro}</h3>
    </c:if>
    <c:if test="${empty erro}">
        <c:if test="${empty clienteList}">
            <h3 class="mensagem" >A agenda de clientes está vazia!</h3>
        </c:if>
        <c:if test="${not empty clienteList}">
            <table class="lista" >
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Nome conjugue</th>
                        <th>Origem</th>
                        <th>Telefone</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clienteList}" var="cliente" varStatus="id">
                        <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ccc' }">
                            <td>${cliente.nome }</td>
                            <td>${cliente.nomeconjugue }</td>
                            <td>${cliente.origem }</td>
                            <td>${cliente.telefone }</td>
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
                            <td><a href="<c:url value="/historico/lista/${cliente.id}"/>">
                                    Listar históricos
                                </a></td>
                            <td><a href="<c:url value="/historico/${cliente.id}"/>">
                                    Adicionar histórico
                                </a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </c:if>
</div>
<c:import url="http://localhost:8080/corretor/rodape.jsp" />
