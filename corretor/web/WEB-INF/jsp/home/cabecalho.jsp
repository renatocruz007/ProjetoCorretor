<%-- 
    Document   : cabecalho
    Created on : 02/09/2012, 23:41:46
    Author     : Alexey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="http://localhost:8080/corretor/css/estilos.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda de Clientes</title>
    </head>
    <body >
<div id="menu">

    <a href="/corretor/home/home">Home</a>


    <a href="<c:url value="/cliente/novo"/>">Cliente</a>

    <a href="/corretor/cliente/lista">Lista de Clientes</a>


</div>
