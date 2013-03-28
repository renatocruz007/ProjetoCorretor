<%-- 
    Document   : formularioContato
    Created on : 23/03/2013, 13:07:44
    Author     : rcruzsil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/home/cabecalho.jsp" />
<h1>Hello World!</h1>
<c:if test="${empty cliente}">
    <h2>Um erro ocorreu</h2>
</c:if>
<c:if test="${not empty cliente}">
    <form action="<c:url value="/cliente/${cliente.id }"/>" method="POST">
        <fieldset>
            <legend>Editar Produto</legend>
            <table class="cadastro"  >
                <tr>
                    <td class="cadastro">
                        <label class="cadastro" for="nome">Nome:</label>
                    </td>
                    <td>
                        <input id="nome" type="text" name="cliente.nome"
                               value="${cliente.nome}"/>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="nomeconjugue">Nome do Cônjugue:</label>
                    </td>
                    <td>
                        <input id="nomeconjugue" type="text" name="cliente.nomeconjugue"
                               value="${cliente.nomeconjugue}"/>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="produtointeresse">Produto de interesse:</label>
                    </td>
                    <td>
                        <input id="produtointeresse" type="text" name="cliente.produtointeresse"
                               value="${cliente.produtointeresse}"/>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="origem">Origem do cadastro:</label>
                    </td>
                    <td>
                        <input id="origem" type="text" name="cliente.origem"
                               value="${cliente.origem}"/>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="enderecoResidencial">Endereço Residencial</label>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="ruares">Rua Residencial:</label>
                    </td>
                    <td>
                        <input id="ruares" type="text" name="cliente.ruares"
                               value="${cliente.ruares}"/>
                    </td>                    
                    <td class="cadastro">
                        <label for="numres">Número Residencial:</label>
                    </td>
                    <td>
                        <input id="numres" type="text" name="cliente.numres"
                               value="${cliente.numres}"/>
                    </td>                   
                    <td class="cadastro">
                        <label for="bairrores">Bairro Residencial:</label>
                    </td>
                    <td>
                        <input id="bairrores" type="text" name="cliente.bairrores"
                               value="${cliente.bairrores}"/>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="enderecoComercial">Endereço Comercial</label>
                    </td>
                </tr>
                <tr>
                    <td class="cadastro">
                        <label for="ruacom">Rua Comercial:</label>
                    </td>
                    <td>
                        <input id="ruacom" type="text" name="cliente.ruacom"
                               value="${cliente.ruacom}"/>
                    </td>
                    <td class="cadastro">
                        <label for="numcom">Número Comercial:</label>
                    </td>
                    <td>
                        <input id="numcom" type="text" name="cliente.numcom"
                               value="${cliente.numcom}"/>
                    </td>
                    <td class="cadastro">
                        <label for="bairrocom">Bairro Comercial:</label>
                    </td>
                    <td>
                        <input id="bairrocom" type="text" name="cliente.bairrocom"
                               value="${cliente.bairrocom}"/>
                    </td>
                </tr>
            </table>
            <button type="submit" name="_method" value="PUT">
                Enviar
            </button>
        </fieldset>
    </form>
</c:if>
</body>
</html>
