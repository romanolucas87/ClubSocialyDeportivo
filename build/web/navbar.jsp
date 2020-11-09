<%-- 
    Document   : navbar
    Created on : 7 nov. 2020, 18:00:30
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-sm bg-danger navbar-dark align-items-center">

    <ul class="navbar-nav align-items-center" style="color: #FAFAFA">
        <li class="nav-item active">
            <a class="nav-link" href="index.jsp">INICIO</a>
        </li>
    </ul>  
    <ul class="navbar-nav align-items-center" style="color: #FAFAFA">
        <li class="nav-item active">
            <a class="nav-link" href="PortalDeNoticias">NOTICIAS</a>
        </li>
    </ul>  
    <c:choose>
        <c:when test="${ not empty usr}">

            <ul class="navbar-nav">
                <li class="nav-item active dropdown">
                    <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">SOCIO</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="AltaSocio">Alta Socio</a>
                        <a class="dropdown-item" href="listadoSocio.jsp">Listado Socios</a>
                        <a class="dropdown-item" href="listadoSocioActividad.jsp">Actividades Por Socio</a>
                        <a class="dropdown-item" href="InscripcionSocio">Inscripcion a Actividades</a>
                        <a class="dropdown-item" href="listadoSocio.jsp">Pagar Cuota</a>
                    </div>
                </li>   
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item active dropdown">
                    <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">ACTIVIDADES</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="AltaActividad">Alta Actividad</a>
                        <a class="dropdown-item" href="listadoActividades.jsp">Consultar Actividades</a>
                    </div>
                </li>   
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item active dropdown">
                    <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">NOTICIAS</a>
                    <div class="dropdown-menu" aria-labelledby="dropdown01">
                        <a class="dropdown-item" href="Noticias?modo=agregar"> Agregar Noticias</a>
                        <a class="dropdown-item" href="Noticias">Listado Noticias</a>
                    </div>
                </li>   
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="Reportes">REPORTES</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="CerrarSesion">CERRAR SESION</a>
                </li>
            </ul>
        </c:when>
        <c:otherwise>
            <ul class="navbar-nav" style="color: #FAFAFA">
                <li class="nav-item active">
                    <a class="nav-link" href="Login">LOGIN</a>
                </li>
            </ul>  

        </c:otherwise>
    </c:choose>
</nav>          
