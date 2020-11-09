

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
        <title>Noticias Admin</title>

    </head>

    <body>     
        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container acomodar">
                    <h1 class="text-center">                            
                         NOTICIAS                            
                        </h1>
                    <div class="row justify-content-center m-4  ">
                        
                        <div class="col text-center">
                            <table class=" table table-striped table-light table-hover ">                          
                                <tr>
                                    <th scope="col">Actividad</th>
                                    <th scope="col">Noticia</th>
                                    <th scope="col"></th>
                                </tr>
                                <c:forEach items="${gestor.noticias}" var="noticia" >
                                    <tr> 
                                        <td>  ${noticia.idActividad.nombreActividad}  </td>
                                        <td>   ${noticia.descripcionNoticia}</td>                                    
                                        <td class="text-center">
                                            <c:choose> 
                                                <c:when test="${noticia.estadoNoticia}">
                                                    <a class="btn btn-danger d-block"  href="Noticias?modo=accion&idNoticia=${noticia.idNoticia}">Deshabilitar</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="btn btn-info d-block" href="Noticias?modo=accion&idNoticia=${noticia.idNoticia}">Habilitar</a>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>

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
