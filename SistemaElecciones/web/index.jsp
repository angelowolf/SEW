<%-- 
    Document   : index
    Created on : 06-jul-2014, 14:53:13
    Author     : Angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="https://netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" media="all" rel="stylesheet">
        <link href="https://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" media="all" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.1.0/animate.min.css" media="all" rel="stylesheet">
        <link href="http://fonts.googleapis.com/css?family=Raleway:300,500" rel="stylesheet" type="text/css">
        <link href="css/stylesLogin.css" media="all" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.1/modernizr.min.js"></script>
    </head>

    <body>


        <div class="wrapper">
            <div class="form-header">
                <h1>S.E.W. - Sistema de Elecciones WEB</h1>
            </div>
            <s:form class="form animate-form" id="form" action="login" namespace="/">
                <s:actionerror theme="bootstrap"/>
                <s:actionmessage theme="bootstrap"/>
                <s:fielderror theme="bootstrap"/>
                <div class="form-group has-feedback">
                    <label class="control-label sr-only" for="username">Nombre de Usuario</label>
                    <div class="input-group-addon">
                        <div class="glyphicon glyphicon-user"></div>
                    </div>
                    <input class="form-control" id="username" name="username" placeholder="Usuario" type="text">
                    <span class="glyphicon glyphicon-ok form-control-feedback"></span>
                </div>
                <div class="form-group has-feedback">
                    <label class="control-label sr-only" for="password">Contraseña</label>
                    <div class="input-group-addon">
                        <div class="glyphicon glyphicon-lock"></div>
                    </div>
                    <input class="form-control" id="password" name="password" placeholder="Contraseña" type="password"><span class="glyphicon glyphicon-ok form-control-feedback"></span>
                </div>
                <div class="form-group submit">
                    <input class="btn btn-lg" type="submit" value="ENVIAR">
                </div>
                <div class="">
                    <a href="RegistrarUsuario.jsp">Crear Cuenta</a>
                </div>
            </s:form>
        </div>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/jquery.validation.js"></script>
        <script src="js/messages_es.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
