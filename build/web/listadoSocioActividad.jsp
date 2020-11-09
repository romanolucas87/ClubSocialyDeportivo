

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
        <title>Listado Socio x Actividad</title>

    </head>
    <%--  <jsp:include page="menu.jsp" />--%>
    <body>
        <div class="container acomodar border w-25">
  <h1 class="text-center mt-3">
                    Listado Actividad por Socio 
                </h1>
            <div class="row justify-content-center  ">
              
                <form class="form-horizontal " method="POST" action="FiltradoActividadSocio" >
                    <div class="col mt-4">
                        <select class="form-control"  name="idSocio" >

                            <c:forEach var="itemCombo" items="${gestor.comboSocio}">
                                <option value="${ itemCombo.idSocio}">${itemCombo.nombreSocio}</option>
                            </c:forEach>
                        </select>
                        <div class="mt-4 mb-4 text-center">                                                       
                                <button class="btn btn-danger" type="submit">FILRAR </button>                            
                        </div>
                    </div>
                </form>

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
