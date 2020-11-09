

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
        <title>Listado Actividades</title>

    </head>
 
    <body>
       


        <c:choose>
            <c:when test="${ not empty usr}">
               
                <div class="container text-center acomodar ">
                    <h1 class="mb-4">
                        Listado de Actividades
                    </h1>
                    <div class="table row justify-content-center">
                    <table class="table-responsive-lg table-striped table-light table-hover ">
                        
                        <tr>
                            <th scope="col">ACTIVIDAD</th>
                            <th scope="col">PRECIO</th>
                            <th scope="col">ACCIONES</th>                                                     

                        </tr>
                       
                        <c:forEach items="${gestor.actividades}" var="actividad" >
                                          
                            <c:if test="${not empty actividad.nombreActividad}"> 
                                <tr class="text-center"> 
                                    <td scope="row"> ${actividad.nombreActividad} </td>
                                    <td scope="row"> ${actividad.precioActividad} </td>
                                   
                                    <td scope="row"> 
                                        <a class="btn btn-info" href="EditarActividad?idActividad=${actividad.idActividad}">Editar</a>
                                        <a class="btn btn-danger" href="EliminarActividad?idActividad=${actividad.idActividad}">Eliminar</a>
                                    </td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    
                    </table>
                </div>
                    
                </div>
               
            </c:when>
        </c:choose>
        
        
        
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
