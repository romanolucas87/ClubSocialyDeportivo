

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">


        <title>PORTAL DE NOTICIAS</title>

    </head>

    <body>

        <jsp:include page="navbar.jsp" />
        <div class="container acomodar">
            <div class="row justify-content-center align-items-center minh-100">
                <div class="col">
                    <h1 class="text-center">PORTAL DE NOTICIAS</h1>
                    <form class="form-check" method="POST" action="PortalDeNoticias" >                
                        <div class="text-center justify-content-center ">
                            <select class="form-control col-5"  name="idActividad" >
                                <option selected>Seleccione una Actividad </option>
                                <c:forEach var="itemCombo" items="${gestor.actividades}">
                                    <option value="${ itemCombo.idActividad }">${itemCombo.nombreActividad}</option>
                                </c:forEach>
                            </select>                              
                            <button class="btn btn-primary" type="submit" id="idActividad"> Filtrar </button>                              
                        </div>                        
                    </form>
                    <c:choose>

                        <c:when test="${not empty lista}"> 
                            <div class="container" style="margin-top: 30px">
                                <div class="table ">
                                    <table class=" table table-light table-hover col-auto"> 
                                        <c:forEach items="${lista}" var="noticia" >
                                            <tr>
                                                <th scope="col" class=" text-center h3 border-0 border-dark">${noticia.idActividad.nombreActividad} </th>                                                    
                                            </tr>    
                                            <tr>                                    
                                                <td>${noticia.descripcionNoticia}</td>                                    
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>

                            </div>
                        </c:when>

                    </c:choose>
                </div>
            </div>

        </div> 

  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
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
