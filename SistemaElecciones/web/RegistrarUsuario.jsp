 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        <link rel="stylesheet" href="css/bootstrap.css">
                <link rel="stylesheet" href="css/bootstrap.min.css.css">-->

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-group col-md-4 col-md-offset-4">
            <%--<s:actionerror theme="bootstrap"/>--%>
            <%--<s:actionmessage theme="bootstrap"/>--%>
            <%--<s:fielderror theme="bootstrap"/>--%>
            <s:form action="registrar_usuario" method="post" validate="true"enctype="multipart/form-data" theme="bootstrap">

                <s:textfield name="nick" label="Nombrde de Usuario"/>

                <s:textfield name="clave" label="Contraseña"/>

                <s:submit value="Registrar" cssClass="btn btn-primary col-md-offset-9 col-md-3"/>
            </s:form>
        </div>

    </body>
</html>
