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

                                String a = (String) session.getAttribute("user");

                            %>
                            <label for="nombre">USER:</label><input type="text" placeholder="Email" readonly="true" class="form-control" value='<% out.println(a); %>'>
                        </div>
                        <button type="submit" name="out" class="btn btn-success">Salir</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="container">
            <br><br><br>
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Actualizar</h3>
                    </div>
                    <%
                        int id = Integer.parseInt(request.getParameter("editar"));
                        Conex con = new Conex();
                        con.setConsulta("select * from libros where libro_id='" + id + "'");
                    %>
                    <div class="panel-body">
                        <% while (con.getResultado().next()) {  %>

                        <form method="POST" action="../ServletLibro?editar=si">
                            <%
                                HttpSession s = request.getSession();
                                Integer ad = (Integer) s.getAttribute("use");

                            %>
                            IdUsuario: <input type="text" readonly="true" value='<% out.println(ad); %>' name="idd">

                            IdLibro:<input type="text" readonly="true" value='<% out.println("" + con.getResultado().getString("libro_id")); %>' name="id"><br><br>
                            <div class="form-group">
                                <label for="nombre">Isbn </label>
                                <input type="text" class="form-control" name="isbn" value='<% out.println("" + con.getResultado().getString("isbn")); %>' id="nombre" placeholder="Ingresar Nombre">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Nombre </label>
                                <input type="text" class="form-control" name="nombre" value='<% out.println("" + con.getResultado().getString("nombre")); %>' id="nombre" placeholder="Ingresar Nombre">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Cantidad_pag </label>
                                <input type="text" class="form-control" name="cantidad" value='<% out.println("" + con.getResultado().getString("cantidad_paginas")); %>' id="nombre" placeholder="Ingresar Nombre">
                            </div>
                            <div class="form-group">
                                <label for="nombre">Autor</label>
                                <select  name="autor" class="form-control">

                            

                                    <%

                                        con.setConsulta("select * from autores where estado='activo'");
                                    %>




                                    <% while (con.getResultado().next()) { %>
                                    <option value=<% out.println("" + con.getResultado().getString("autor_id")); %>><% out.println("" + con.getResultado().getString("nombre")); %></option>
                                    <%}%>
                                    
                                    
                                    
                                    
                                </select>


                            </div>

                            <div class="form-group">
                                <label for="nombre">Idioma</label>
                                  <select  name="idioma" class="form-control">
                          
                                <%

                                    con.setConsulta("select * from idiomas where estado='activo'");
                                %>
                              
                                    <% while (con.getResultado().next()) { %>
                                    <option value=<% out.println("" + con.getResultado().getString("idioma_id")); %>><% out.println("" + con.getResultado().getString("nombre")); %></option>
                                    <% } %>
                                </select>


                            </div>




                            <button type="submit" class="btn btn-default">ACTUALIZAR</button>
                        </form>
                        <% }%> 

                    </div>
                </div>
            </div>
        </div><!-- /.container -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="../template/js/bootstrap.min.js"></script>

    </body>
</html>