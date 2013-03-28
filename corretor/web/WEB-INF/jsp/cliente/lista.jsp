<%-- 
    Document   : lista
    Created on : 28/08/2012, 00:43:15
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/home/cabecalho.jsp" />
<h1>Lista de Clientes</h1>
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
</body>
</html>
