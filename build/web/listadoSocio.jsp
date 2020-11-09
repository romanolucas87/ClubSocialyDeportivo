

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">

        <title>Listado de Socios</title>
        <jsp:include page="navbar.jsp" />
    </head>

    <body>    



        <c:choose>
            <c:when test="${ not empty usr}">

                <div class="container acomodar">

                    <div class="table">
                        <table class="table-responsive-lg  table-striped table-light table-hover text-center">
                            <!-- <thead>-->
                            <tr>
                                <th scope="col">Nombre</th>
                                <th scope="col">Apellido</th>
                                <th scope="col">Telefono</th>
                                <th scope="col" >Direccion</th>
                                <th scope="col" >Fecha Nacimiento</th>
                                <th scope="col" >Nacionalidad</th>
                                <th scope="col" class="text-center">Tipo de Documento</th>
                                <th scope="col" class="text-center">Nro de Documento</th>
                                <th scope="col" class="text-center">E-Mail</th>
                                <th scope="col" class="text-center">Acciones</th>

                            </tr>
                            <!--   </thead>-->
                            <c:forEach items="${gestor.socios}" var="socio" >
                                <!-- <tbody>   -->                       
                                <c:if test="${not empty socio.nombreSocio}"> 
                                    <tr class="text-center"> 
                                        <td scope="row"> ${socio.nombreSocio} </td>
                                        <td scope="row"> ${socio.apellidoSocio} </td>
                                        <td scope="row"> ${socio.telefono} </td>
                                        <td scope="row"> ${socio.direccion} </td>
                                        <td scope="row"> ${socio.fechaNacimiento} </td>
                                        <td scope="row"> ${socio.nacionalidad} </td>
                                        <td scope="row"> ${socio.tipoDocumento} </td>
                                        <td scope="row"> ${socio.nroDocumento} </td>
                                        <td scope="row"> ${socio.email} </td>
                                        <td scope="row"> 
                                            <a class="btn btn-info mb-2  d-block" href="EditarSocio?idSocio=${socio.idSocio}">Editar</a>
                                            <a class="btn btn-dark mb-2  d-block" href="EliminarSocio?idSocio=${socio.idSocio}">Eliminar</a>
                                            <a class="btn btn-success mb-2 d-block" href="Pagos?idSocio=${socio.idSocio}">REGISTRAR PAGO</a>

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
