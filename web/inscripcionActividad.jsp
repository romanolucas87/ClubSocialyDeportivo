

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
        <jsp:include page="navbar.jsp" />

        <%-- <jsp:include page="menu.jsp" /> --%>
        <title>Inscripcion Actividad</title>
    </head>

    <body>

        <jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
        <jsp:useBean id="modeloSocio" class="Modelo.Socio" scope="request" />

        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container acomodar">
                    <h1 class="text-center">INSCRIPCION</h1>  
                    <form class="form-horizontal" method="POST" action="InscripcionSocio" > 
                        <div class="form-group">
                            <div class="row d-flex justify-content-center ">
                                <table class=" table table-striped table-light border-white table-hover text-center w-50">
                                    <tbody>
                                        <tr>
                                            <th class="text-center " scope="row">Socio</th>
                                            <td class="text-center "><select class="form-control input-sm combo"  name="idSocio" >
                                                    <option selected>Elija un Socio </option>
                                                    <c:forEach var="comboSocio" items="${gestor.comboSocio}">
                                                        <option value="${comboSocio.idSocio}">${comboSocio.nombreSocio}</option>
                                                    </c:forEach>
                                                </select></td>        
                                        </tr>
                                        <tr>
                                            <th class="text-center " scope="row">Actividad</th>
                                            <td class="text-center "><select class="form-control input-sm combo"  name="idActividad" >
                                                    <option selected>Elija una Actividad </option>
                                                    <c:forEach var="comboActividad" items="${gestor.actividades}">
                                                        <option value="${comboActividad.idActividad}">${comboActividad.nombreActividad}</option>
                                                    </c:forEach>
                                                </select></td>        
                                        </tr>                                                                                   
                                    </tbody>
                                </table> 
                            </div>
                        </div>

                        <div class="form-group text-center">
                            <div class="col-xs-12">
                                <button class="btn btn-danger" type="submit" id="nuevaInscripcion"> INSCRIBIR</button>
                            </div>
                        </div>
                    </form>
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


<!-- private String nombreSocio;
 private String apellidoSocio;
 private int telefonoSocio;
 private String direccionSocio;
 private String fechaNacimiento;
 private int idNacionalidad;
 private int tipoDocumento;
 private int documentoSocio;
 private String email;-->


