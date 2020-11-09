<%-- 
    Document   : nuevoSocio
    Created on : 28 oct. 2020, 22:19:27
    Author     : Lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <link rel="stylesheet" href="css/style.css">
         <jsp:include page="navbar.jsp" />

        <title>Modificar Socio</title>
    </head>

    <body>



        <jsp:setProperty name="modeloSocio" property="*" />
        <c:choose>
            <c:when test="${ not empty usr}">

                <div class="container acomodar">
                    <h1 class="text-center acomodar">Modificar Socios</h1>  
                    <form class="form-horizontal border-danger" method="POST" action="EditarSocio" > 
                        <div class="form-group">
                            <input type="hidden" name="idSocio" value="<jsp:getProperty name="modeloSocio" property="idSocio"></jsp:getProperty>"/>

                                <div class="row d-flex justify-content-center ">
                                    <table class=" table table-striped table-light border-white table-hover text-center w-50">
                                        <tbody>
                                            <tr>
                                                <th class="text-center " scope="row">Nombre</th>
                                                <td class="text-center "><input type="text" name="nombreSocio" value="<jsp:getProperty name="modeloSocio" property="nombreSocio"></jsp:getProperty>"/>					
                                                </td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Apellido</th>
                                                <td class="text-center "><input type="text" name="apellidoSocio" value="<jsp:getProperty name="modeloSocio" property="apellidoSocio"></jsp:getProperty>"/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Telefono</th>
                                                <td class="text-center"><input type="text" name="telefonoSocio" value="<jsp:getProperty name="modeloSocio" property="telefonoSocio"></jsp:getProperty>"/> </td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Direccion</th>
                                                <td class="text-center"><input type="text" name="direccionSocio" value="<jsp:getProperty name="modeloSocio" property="direccionSocio"></jsp:getProperty>"/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Fecha Nacimiento</th>
                                                <td class="text-center"><input type="text" name="fechaNacimiento" value="<jsp:getProperty name="modeloSocio" property="fechaNacimiento"></jsp:getProperty>"/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Nacionalidad</th>
                                                <td ><select class="form-control combo"  name="idNacionalidad" >
                                                        <!--<option selected>Seleccione una Nacionalidad </option>-->
                                                    <c:forEach var="itemCombo" items="${gestor.comboNacionalidades}">
                                                        <option value="${ itemCombo.idNacionalidad }" <c:if test="${itemCombo.idNacionalidad == modeloSocio.idNacionalidad}"> selected </c:if>>${itemCombo.descripcionNacionalidad}</option>
                                                    </c:forEach>
                                                </select></td>        
                                        </tr>
                                        <tr>
                                            <th  class="text-center" scope="row">Tipo de Documento</th>
                                            <td class="text-center "><select class="form-control input-sm combo"  name="tipoDocumento" >
                                                    <!--<option selected>Seleccione una Nacionalidad </option>-->
                                                    <c:forEach var="itemCombo" items="${gestor.comboTipoDocumento}">
                                                        <option value="${itemCombo.idTipoDocumento}"<c:if test="${itemCombo.idTipoDocumento == modeloSocio.tipoDocumento}"> selected </c:if>>${itemCombo.descripcionDocumento}</option>
                                                    </c:forEach>
                                                </select></td>        
                                        </tr>
                                        <tr>
                                            <th class="text-center" scope="row">Numero de Documento</th>
                                            <td class="text-center"><input type="text" name="documentoSocio" value="<jsp:getProperty name="modeloSocio" property="documentoSocio"></jsp:getProperty>"/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">E-MAIL</th>
                                                <td class="text-center"><input type="email" name="email" value="<jsp:getProperty name="modeloSocio" property="email"></jsp:getProperty>"/></td>        
                                            </tr>


                                        </tbody>
                                    </table> 
                                </div>
                            </div>

                            <div class="form-group text-center">
                                <div class="col-xs-12">
                                    <button class="btn btn-danger" type="submit"> Guardar</button>
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


