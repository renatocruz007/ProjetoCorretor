<%-- 
    Document   : lista
    Created on : 23/03/2013, 18:49:43
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<c:import url="http://localhost:8080/corretor/cabecalho.jsp" />
<div class="principal">
    <h1 class="principal">Lista de Históricos</h1>
    <c:if test="${not empty erro}">
        <h3 class="mensagem">${erro}</h3>
    </c:if>
    <c:if test="${empty erro}">
        <c:if test="${empty historicoList}">
            <h3 class="mensagem" >O cliente não possui históricos cadastrados!</h3>
        </c:if>
        <c:if test="${not empty historicoList}">
            <table class="lista">
                <input style="visibility: hidden" id="id" type="text" name="cliente.id" value="${cliente.id}"/>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Data</th>
                        <th>Descrição</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${historicoList}" var="historico" varStatus="id">
                        <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ccc' }">
                            <td>${historico.idclienteId.nome}</td>
                            <td><fmt:formatDate value="${historico.data.time}"
                                            pattern="dd/MM/yyyy" /></td>
                            <td><textarea  cols=30 rows="4" readonly id="descricao" name="historico.descricao"
                                      >${historico.descricao}</textarea></td>
                            <td><a href="<c:url value="/historico/edita/${historico.id}"/>">
                                    Editar
                                </a></td>
                            <td>
                                <form action="<c:url value="/historico/${historico.id}"/>"
                                      method="POST">
                                    <button class="link" name="_method" value="DELETE">
                                        Remover
                                    </button>
                                </form>
                            </td>
                            <td><a href="<c:url value="/historico/${historico.idclienteId.id}"/>">
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
