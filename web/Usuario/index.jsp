<%@page import="Acceso.Conex"%>
<%@page import="java.util.*"  session="true"%>
<%@page import="negocio.Usuario"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <title>Starter Template for Bootstrap</title>
        <link href="../template/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
       <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Project name</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="../index.jsp">Home</a></li>
                      
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Autor<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="../Autor/index.jsp">Autor</a></li>
                                <li><a href="../Autor/crear.jsp">Nuevo</a></li>
                               
                            </ul>
                        </li>
                            <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Libro<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="../Libro/index.jsp">Libro</a></li>
                                <li><a href="../Libro/crear.jsp">Nuevo</a></li>
                               
                            </ul>
                        </li>
                         <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Idioma<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="../Idioma/index.jsp">Idioma</a></li>
                                <li><a href="../Idioma/crear.jsp">Nuevo</a></li>
                              
                               
                            </ul>
                        </li>
                           <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuario<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                                           <li><a href="../Usuario/index.jsp">Usuario</a></li>

                                <li><a href="../Usuario/crear.jsp">Nuevo</a></li>
                                
                               
                            </ul>
                        </li>
                    </ul>
                          <form class="navbar-form navbar-right" method="post" action="../inicio"> 
           <div class="form-group">
                 <%
                           
                            String a=(String)session.getAttribute("user");
                            
                            %>
                             <label for="nombre">USER:</label><input type="text" placeholder="Email" readonly="true" class="form-control" value='<% out.println(a); %>'>
            </div>
            <button type="submit" name="out" class="btn btn-success">Salir</button>
          </form>
                </div>
            </div>
        </nav>
            <%

                Usuario usu = (Usuario) session.getAttribute("usuario");
                session.setAttribute("usuario", usu);

                if (usu == null) {

                    response.sendRedirect("../login.jsp");

                }

            %>
        <div class="container">
            <br><br><br>
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Listar Usuarios</h3>
                    </div>
                    <div class="panel-body">
                        <a href="crear.jsp" class="btn btn-primary">NUEVO USUARIO</a>
                        <br><br>
                        <form method="POST" action="index.jsp">
                            <div class="form-group">
                                <label for="nombre">buscar </label>
                                <input type="text" class="form-control" name="buscarNombre" id="nombre" placeholder="Ingresar Nombre">
                            </div>
                            <button type="submit" class="btn btn-default" name="buscar">buscar</button> 
                        </form>   
                        <br>
                        <table class="table table-condensed table-hover table-bordered">
                            <thead>
                            <th>ID</th>
                            <th>User</th>
                            <th>ELIMINAR</th>
                            <th>EDITAR</th>

                            </thead>
                            <tbody>
                                <%
                                    Conex con = new Conex();
                                    if (request.getParameter("buscarNombre") != null) {
                                        if (request.getParameter("buscarNombre").isEmpty()) {
                                            con.setConsulta("select * from usuarios where estado='activo'");
                                        } else {
                                            String nombre = request.getParameter("buscarNombre");
                                            con.setConsulta("select * from usuarios where user like '%" + nombre + "%' and estado='activo'");
                                        }
                                    }else {
                                        con.setConsulta("select * from usuarios where estado='activo'");
                                    }
                                    while (con.getResultado().next()) {
                                        out.println("<tr>");
                                        out.println("<td>" + con.getResultado().getString("usuario_id") + "</td>");
                                        out.println("<td>" + con.getResultado().getString("user") + "</td>");
                                        out.println("<td>" + "<a href='../ServletUsuario?eliminar=" + con.getResultado().getString("usuario_id") + "' class='btn btn-danger'>Eliminar</a>" + "</td>");

                                        out.println("<td>" + "<a href='editar.jsp?editar=" + con.getResultado().getString("usuario_id") + "' class='btn btn-primary'>Editar</a>" + "</td>");

                                        out.println("</tr>");
                                    }
                                %>
                            </tbody>

                        </table>



                    </div>
                </div>
            </div>
        </div><!-- /.container -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="../template/js/bootstrap.min.js"></script>

    </body>
</html>
