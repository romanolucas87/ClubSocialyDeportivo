<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

              <link rel="stylesheet" href="css/style.css">


        <link href="signin.css" rel="stylesheet" />
        <title>Login</title>
    </head>

    <body>

        <div class="container ">
            <div class="row justify-content-center">
                <div class="col-md-auto">
                    <div class="card-body acomodar">

                        <form class="form-control text-center border border-bottom-0" action="Login" method="POST">

                            <p class="h4 mb-4">Portal de Administracion</p>

                            <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) { %>
                            <h5 class="text-danger small "> <strong>${ mensajeError }</strong></h5> <% }%>

                            <input type="text" name="txtUsuario" id="defaultSubscriptionFormPassword" class="form-control mb-4" placeholder="Usuario">

                            <input type="password" name="txtPass" id="defaultSubscriptionFormEmail" class="form-control mb-4" placeholder="Contraseña">

                            <button class="btn btn-danger btn-block" type="submit">Ingresar</button>


                        </form>
                    </div>
                </div>            
            </div> 
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
    </body>              
</html>
