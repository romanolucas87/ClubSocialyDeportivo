

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
        <jsp:include page="navbar.jsp" />
        <title>Listado Actividad x socio</title>

    </head>

    <body>
        <div class="container acomodar text-center">
            <div class="h1 mb-5">
                Listado Actividad por Socio 
            </div>
            <c:choose>
                <c:when test="${ not empty usr}">
                    <div class="row justify-content-center align-items-center ">
                        <div class="col-8"> 
                            <div class="table">
                                <table class="table table-responsive-light table-striped table-primary table-hover"> 
                                    <tr>
                                        <th>
                                            NOMBRE SOCIO
                                        </th>                                     
                                        <th>
                                            NOMBRE ACTIVIDAD
                                        </th>                                     
                                        <th>
                                            CANCELAR
                                        </th>                                     
                                    </tr>    
                                    <c:forEach items="${lista}" var="dto" >
                                        <tr>      
                                            <td scope="col">${dto.nombreSocio} </td>                                 
                                            <td>${dto.nombreActividad}</td>                                    
                                            <td><a class="btn btn-danger" href="CancelarInscripcion?modo=baja&idActividad=${dto.idActividad}&idSocio=${dto.idSocio}">CANCELAR INSCRIPCION   </a></td>                                    
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                            <form class="form-check-inline" method="POST" action="CancelarInscripcion" >

                            </form> 
                        </div>

                    </c:when>
                </c:choose>
            </div>

        </div> 
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous">
        </script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
        </script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
        </script>

    </body>
</html>