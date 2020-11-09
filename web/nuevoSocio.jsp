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

        <title>Alta Socio</title>

        <jsp:include page="navbar.jsp" />
        <title>Alta Socio</title>
    </head>

    <body>

        <jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
        <jsp:useBean id="modeloSocio" class="Modelo.Socio" scope="request" />
        <jsp:setProperty name="nuevoSocio" property="*" />

        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container acomodar">
                    <h1 class="text-center acomodar">AGREGAR SOCIO</h1>  
                    <form class="form-horizontal" method="POST" action="AltaSocio" > 
                        <div class="form-group">
                            <input type="hidden" name="idSocio" value="<jsp:getProperty name="modeloSocio" property="idSocio"></jsp:getProperty>"/>

                                <div class="row d-flex justify-content-center ">
                                    <table class="table table-responsive-light table-bordered bg-white w-50">

                                        <tbody>
                                            <tr>
                                                <th class="text-center " scope="row">Nombre</th>
                                                <td class="text-center "><input class="w-100" type="text" name="nombreSocio"required=""/>					
                                                </td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Apellido</th>
                                                <td class="text-center "><input  class="w-100" type="text" name="apellidoSocio" required=""/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Telefono</th>
                                                <td class="text-center"><input class="w-100" type="number" name="telefonoSocio"required=""/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Direccion</th>
                                                <td class="text-center"><input class="w-100" type="text" name="direccionSocio"required=""/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Fecha Nacimiento</th>
                                                <td class="text-center"><input class="w-100" type="text" name="fechaNacimiento" required=""/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Nacionalidad</th>
                                                <td ><select class="form-control "  name="idNacionalidad" >
                                                        <option selected>Seleccione una Nacionalidad </option>
                                                    <c:forEach var="itemCombo" items="${gestor.comboNacionalidades}">
                                                        <option value="${ itemCombo.idNacionalidad }">${itemCombo.descripcionNacionalidad}</option>
                                                    </c:forEach>
                                                </select></td>        
                                        </tr>
                                        <tr>
                                            <th  class="text-center" scope="row">Tipo de Documento</th>
                                            <td class="text-center "><select class="form-control"  name="tipoDocumento" >
                                                    <option selected>Seleccione un Documento </option>
                                                    <c:forEach var="itemCombo" items="${gestor.comboTipoDocumento}">
                                                        <option value="${itemCombo.idTipoDocumento}">${itemCombo.descripcionDocumento}</option>
                                                    </c:forEach>
                                                </select></td>        
                                        </tr>
                                        <tr>
                                            <th class="text-center" scope="row">Numero de Documento</th>
                                            <td class="text-center"><input class="w-100" type="number" name="documentoSocio"required=""/></td>        
                                        </tr>
                                        <tr>
                                            <th class="text-center" scope="row">E-MAIL</th>
                                            <td class="text-center"><input class="w-100" type="email" name="email"/></td>        
                                        </tr>


                                    </tbody>
                                </table> 
                            </div>
                        </div>

                        <div class="form-group text-center">
                            <div class="col-xs-12">
                                <button class="btn btn-danger" type="submit" id="nuevoSocio"> Guardar</button>
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


