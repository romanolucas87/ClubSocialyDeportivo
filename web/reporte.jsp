<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
<jsp:setProperty name="comboActividades" property="*" />
<jsp:setProperty name="comboSocios" property="*" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
        <jsp:include page="navbar.jsp" />
        <title>REPORTES</title>
    </head>
    <body>
        <h1 class="text-center">
            REPORTES
        </h1>

        <div class="container  bg-white w-50">

            <div class="row-cols-lg-1 m-4 justify-content-center text-center mt-4">
                <div class="col-12">
                    <form class="form " action="Reportes" method="POST">
                        <div class="mb-3 mt-4 "> <p class="h5 mb-3 ">LISTADO SOCIOS INSCRIPTOS A UNA ACTIVIDAD EN PARTICULAR </p>                         
                            <select class="form-control input-sm combo mb-2"  name="actividad" >
                                <option selected>Elija una Actividad </option>
                                <c:forEach var="comboActividad" items="${comboActividades}">
                                    <option value="${comboActividad.idActividad}">${comboActividad.nombreActividad}</option>
                                </c:forEach>
                            </select> 
                            <input type="hidden" name="idActividad" value="${actividad_id}"/>
                            <button type="submit" class="btn btn-success">
                                VER
                            </button> 
                        </div>                                
                </div>                                
                </form>
            </div> 

            <div class="row-cols-lg-1 m-4 justify-content-center align-content-center border-top">
                <div class="col-12 ">                
                    <div class="h5 mt-4 mb-3 text-center">MONTO TOTAL GANANCIAS EN CUOTAS</div>
                </div>
                <div class="col">    
                    <div class="text-center"> <a class="btn btn-info"  onclick="window.location = 'Reportes?modo=1';">VER</a></div>
                </div>
            </div>
            <div class="row-cols-lg-1 m-4 justify-content-center align-content-center border-top">
                <div class="col">   
                    <div class="h5 mb-3 mt-4 text-center"> <p class="h5 mb-3">NOMBRE Y TOTAL DE GANANCIAS DE LAS 3 ACTIVIDADES CON MAYOR GANANCIA TOTAL</p>
                        <div class="col">         
                            <div class="text-center"> <a class="btn btn-info "  onclick="window.location = 'Reportes?modo=2';">VER</a></div>
                        </div>                   
                    </div>
                </div>
            </div>  

            <div class="row-cols-lg-1 m-4 justify-content-center text-center border-top">
                <div class="col-12">
                    <form action="Reportes" method="POST" class="form">

                        <div class="mb-3 mt-4"> <p class="h5 mb-3">VER LISTADO SOCIO Y SUS CUOTAS PAGAS </p>
                            <select class="form-control input-sm combo mb-3"  name="socio" >
                                <option selected>Elija un Socio </option>
                                <c:forEach var="comboSocio" items="${comboSocios}">
                                    <option value="${comboSocio.idSocio}">${comboSocio.nombreSocio}</option>
                                </c:forEach>                                          
                            </select>  
                            <input type="hidden" name="idSocio" value="${socio_id}"/>
                            <button type="submit" class="btn btn-success mb-3">
                                VER
                            </button>                                                                 
                    </form>
                </div>
            </div>

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
