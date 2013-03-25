<%-- 
    Document   : lista
    Created on : 23/03/2013, 18:49:43
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/home/cabecalho.jsp" />
<h1>Lista de Clientes</h1>
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
                <td><a href="<c:url value="/cliente/${cliente.id}"/>">
                        Editar
                    </a></td>
                <td>
                    <form action="<c:url value="/cliente/${cliente.id}"/>"
                          method="POST">
                        <button class="link" name="_method" value="DELETE">
                            Remover
                        </button>
                    </form>
                </td>
                <td><a href="<c:url value="/contato/${cliente.id}"/>">
                        Adicionar contato
                    </a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
