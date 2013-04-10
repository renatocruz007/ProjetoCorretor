<%-- 
    Document   : cabecalho
    Created on : 02/09/2012, 23:41:46
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/corretor/css/estilos.css" />
        <script type="text/javascript" src="http://localhost:8080/corretor/js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript">
            function formatarData (date) {
            var currentDt = date;
            var mm = currentDt.getMonth() + 1;
            var dd = currentDt.getDate();
            var yyyy = currentDt.getFullYear();
            var date = mm + '/' + dd + '/' + yyyy;
            alert(date);
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Agenda de Clientes</title>
    </head>
    <body >
        <div id="menu">
            <ul id="nav">
                <li><a href="/corretor/home/home">Home</a></li>
                <li><a href="#" class="selected" >Cliente</a>

                    <ul>
                        <li> <a href="<c:url value="/cliente/novo"/>">Cadastro</a></li>


                        <li><a href="<c:url value="/cliente/lista"/>">Lista</a></li>
                    </ul>
                    <div class="clear"></div>
                </li>
                <li id="buscali" ><form action="<c:url value="/cliente/busca"/>">
                        <input id="busca" name="nome"/>
                    </form>
                    <script type="text/javascript">
                        $("#busca").puts("Busca clientes por nome");
                    </script>
                </li>
            </ul>
        </div>

