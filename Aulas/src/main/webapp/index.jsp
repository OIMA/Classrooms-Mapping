<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Administraci&oacute;n de aulas</title>

        <!-- Bootstrap core CSS -->
        <link type="text/css" href="css/bootstrap.css" rel="stylesheet">
        <link type="text/css" href="css/bootstrap-theme.css" rel="stylesheet">
        <!--<link type="text/css" href="css/tema.css" rel="stylesheet">-->
        <!-- Add custom CSS here -->
        <!--<link type="text/css" rel="stylesheet" href="font-awesome/css/font-awesome.min.css">-->
        <!-- Page Specific CSS -->


    </head>

    <body>
        <div id="wrapper">
            <!-- Sidebar -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="">Administracion de aulas</a>
                </div>
            </nav>

            <div id="page-wrapper" style="margin-top: 10%;">
                <div class="panel panel-default" style="width: 35%;margin-left: auto;margin-right: auto;background: #FFF;">
                    <div class="panel-heading" >
                  <h3 class="" style="margin-left: 30%;margin-right: auto;">Inicio de sesi&oacute;n</h3>
              </div>
              <div class="panel-body">
                  <form class="form-horizontal" action="Formularios.xx">
                        <div class="form-group">
                            <div class="col-sm-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="usuario" class="col-sm-2 control-label">Usuario</label>
                            <div class="col-sm-9 col-sm-offset-1">
                                <input type="text" class="form-control" id="usuario" placeholder="Usuario o e-mail" name="usuario" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contrasenia" class="col-sm-2 control-label">Contrase&ntilde;a</label>
                            <div class="col-sm-9 col-sm-offset-1">
                                <input type="password" class="form-control" id="contrasenia" placeholder="Contrase&ntilde;a" name="contrasenia" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-12">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-4">
                                <button type="submit" class="btn btn-primary btn-lg" >Iniciar</button>
                                </div>
                            </div>
                    </form>
              </div>
            </div>
            </div>
        </div><!-- /#wrapper -->




        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <!--<script type="text/javascript" src="js/llenarAulas.js"></script>-->

    </body>
</html>

