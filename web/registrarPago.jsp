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
        <title>Pagos</title>
    </head>

    <body>

        <jsp:useBean id="gestor" scope="request" class="Controlador.ConexionJDBC"/>
        <jsp:setProperty name="socio" property="*" />
        <jsp:setProperty name="monto" property="*" />

        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container acomodar">
                    <h1 class="text-center">REGISTRAR PAGO</h1>  
                    <form class="form-horizontal" method="POST" action="Pagos" > 
                        <div class="form-group">
                            <input type="hidden" name="idSocio" value="<jsp:getProperty name="socio" property="idSocio"></jsp:getProperty>"/>

                                <div class="row justify-content-center align-items-center  ">
                                    <div>  

                                        <table class="table table-responsive-light table-striped table-light table-hover">

                                            <tbody>
                                                <tr>
                                                    <th class="text-center " scope="row">Nombre</th>
                                                    <td class="text-center "><jsp:getProperty name="socio" property="nombreSocio"></jsp:getProperty>					
                                                    </td>        
                                                </tr>
                                                <tr>
                                                    <th class="text-center" scope="row">Apellido</th>
                                                    <td class="text-center "><jsp:getProperty name="socio" property="apellidoSocio"></jsp:getProperty>	
                                                </tr>
                                                <tr>
                                                    <th class="text-center" scope="row">Cuota</th>
                                                    <td ><select class="form-control text-center d-block"  name="idCuota" >

                                                        <c:forEach var="itemCombo" items="${gestor.comboCuotas}">
                                                            <option class="text-center" value="${ itemCombo.idCuota }">${itemCombo.nroCuota}</option>
                                                        </c:forEach>
                                                    </select></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Monto</th>
                                                <td class="text-center"><input type="text" name="monto" value="${ monto }" required="Debe ingresar un Monto"></td>        
                                            </tr>

                                            <tr>
                                                <th class="text-center" scope="row">Fecha de Pago</th>
                                                <td class="text-center"><input class="w-100" type="text" name="fechaPago"  required="Ingrese La Fecha del Pago"/></td>        
                                            </tr>
                                            <tr>
                                                <th class="text-center" scope="row">Fecha de Vencimiento</th>
                                                <td class="text-center"><input class="w-100" type="text" name="fechaVencimiento" required="Ingrese la Fecha de Vencimiento"/></td>        
                                            </tr>

                                        </tbody>
                                    </table> 
                                </div>

                            </div>
                        </div>

                        <div class="form-group text-center">
                            <div class="col-xs-12">
                                <button class="btn btn-danger" type="submit" > PAGAR</button>
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



