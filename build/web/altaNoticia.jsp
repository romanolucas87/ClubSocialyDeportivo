<%-- 
    Document   : nuevoSocio
    Created on : 28 oct. 2020, 22:19:27
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
        <jsp:include page="navbar.jsp" />
        <title>Alta Noticia</title>
    </head>

    <body>

        <jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
        <jsp:setProperty name="nuevoSocio" property="*" />

        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container-lg acomodar">
                    <div class="row justify-content-center">
                        <div class="col">
                            <h1 class="text-center ">CARGAR NOTICIAS</h1>  

                            <form class="form-horizontal" method="POST" action="Noticias" > 

                                <div class="form-group text-center">
                                    <div class="h4 m-lg-4">
                                        Elija una Actividad: 
                                        <select class="form-control combo col-form-label-sm col-2 mt-3"  name="idActividad" required="">                                           
                                            <c:forEach var="itemCombo" items="${gestor.actividades}">
                                                <option value="${ itemCombo.idActividad }">${itemCombo.nombreActividad}</option>
                                            </c:forEach>
                                        </select>                                     
                                    <textarea class="col-8 mt-lg-3 mb-3" id="exampleFormControlTextarea1" rows="10" name="descripcionNoticia" required=""></textarea>
                                </div>                  
                                <div class="form-group text-center">
                                    <div class="col-xs-12">
                                        <button class="btn btn-danger" type="submit" id="nuevaNoticia"> CARGAR NOTICIA </button>
                                    </div>
                                </div>
                            </form>
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





