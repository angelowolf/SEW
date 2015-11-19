<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Simple Sidebar - Start Bootstrap Template</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link href="font-awesome-4.3.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>

    <nav>
        <ul class="pagination">
            <li>
                <a href="{1}">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li>
                <a href="{2}">
                    <span aria-hidden="true">Anterior</span>
                </a>
            </li>
            {0}
            <li>
                <a href="{3}">
                    <span aria-hidden="true">Siguiente</span>
                </a>
            </li>
            <li>
                <a href="{4}">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>

    <nav>
        <ul class="pagination">
            {0}
            <li>
                <a href="{3}">
                    <span aria-hidden="true">
                        Siguiente
                    </span>
                    <span class="sr-only">
                        siguiente
                    </span>
                </a>
            </li>
            <li>
                <a href="{4}">
                    <span aria-hidden="true">
                        &raquo;
                    </span>
                    <span class="sr-only">
                        ultimo
                    </span>
                </a>
            </li>
        </ul>
    </nav>

    <nav>
        <ul class="pagination">
            <li>
                <a href="{1}">
                    <span aria-hidden="true">
                        &laquo;
                    </span>
                    <span class="sr-only">
                        primera
                    </span>
                </a>
            </li>
            <li>
                <a href="{2}">
                    <span aria-hidden="true">
                        Anterior
                    </span>
                    <span class="sr-only">
                        anterior
                    </span>
                </a>
            </li>
            {0}
        </ul>
    </nav>

    
    
    <span class="pagelinks">
        &nbsp;{0}&nbsp;&nbsp;&nbsp;
        <a class="paging" href="{3}">
            Siguiente&gt;
        </a>
        &nbsp;
        <a class="paging" href="{4}">
            &Uacute;ltimo&gt;&gt;
        </a>
    </span>        


    <nav class="navbar navbar-default no-margin">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header fixed-brand">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"  id="menu-toggle">
                <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
            </button>
            <a class="navbar-brand" href="#"><i class="fa fa-rocket fa-4"></i> SEW</a>        
        </div><!-- navbar-header-->

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active" ><button class="navbar-toggle collapse in" data-toggle="collapse" id="menu-toggle-2"> <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span></button></li>
            </ul>
        </div><!-- bs-example-navbar-collapse-1 -->
    </nav>
    <div id="wrapper">
        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav nav-pills nav-stacked" id="menu">

                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-user fa-stack-1x "></i></span> Candidatos</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-folder-open fa-stack-1x "></i></span> Mesas</a>
                    <ul class="nav-pills nav-stacked" style="list-style-type:none;">
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-list fa-stack-1x "></i></span>Todos</a></li>
                        <li><a href="#"><span class="fa-stack fa-lg pull-left"><i class="glyphicon glyphicon-plus fa-stack-1x "></i></span>Nuevo</a></li>                        </ul>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid xyz">
                <div class="row">

                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/sidebar_menu.js"></script>
</body>
</html>
