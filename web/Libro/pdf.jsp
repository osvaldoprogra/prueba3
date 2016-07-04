<%-- 
    Document   : pdf
    Created on : 02-07-2016, 2:51:18
    Author     : XM21
--%>
<%@page import="negocio.Usuario"%>
<%@page import="java.io.*"%>
<%@page import="Acceso.Conex" %>
<%@page import="net.sf.jasperreports.engine.*" %>
<%@page import="net.sf.jasperreports.view.JasperViewer" %>
<%@page import="javax.servlet.ServletResponse" %>



<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            Usuario usu = (Usuario) session.getAttribute("usuario");
            session.setAttribute("usuario", usu);

            if (usu == null) {

                response.sendRedirect("../login.jsp");

            }

        %>
        
        
        
        
        
        
        
        <%
            try {
                Conex con = new Conex();
                File reportFile = new File(application.getRealPath("//Reportes//Libro.jasper"));
      
                byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),null, con.getConexion());
                response.setContentType("application/pdf");
                response.setContentLength(bytes.length);
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(bytes, 0, bytes.length);
                outputStream.flush();
                outputStream.close();
            } catch (Exception ex) {
                out.println("ERROR DE CONEXION AL GENERAR EL REPORTE! :D");
            }
        %>
    </body>
</html>
