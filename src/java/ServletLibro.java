/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Libro;

/**
 *
 * @author XM21
 */
@WebServlet(urlPatterns = {"/ServletLibro"})
public class ServletLibro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Libro rs = new Libro();
            
            if (request.getParameter("eliminar") != null) {
                int eliminar_id = Integer.parseInt(request.getParameter("eliminar"));
                rs.setLibro_id(eliminar_id);
                rs.delete();
                
                response.sendRedirect("Libro/index.jsp");
                
            } else if (request.getParameter("editar") != null) {
                 int id = Integer.parseInt(request.getParameter("id"));
                String isbn = request.getParameter("isbn");
                String nombre = request.getParameter("nombre");
                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                int idioma=Integer.parseInt(request.getParameter("idioma"));
               int autor=Integer.parseInt(request.getParameter("autor"));
                int idd = Integer.parseInt(request.getParameter("idd"));
                
                rs.setIsbn(isbn);
                rs.setNombre(nombre);
                rs.setCantidad_pagina(cantidad);
                rs.setAutor_id(autor);
                rs.setIdioma_id(idioma);
                rs.setCreado_por(idd);
                rs.setLibro_id(id);
                
                
                rs.update();
                
                response.sendRedirect("Libro/index.jsp");
                
            } else {
                
                String isbn = request.getParameter("isbn");
                String nombre = request.getParameter("nombre");
                int cantidad = Integer.parseInt(request.getParameter("cantidad_paginas"));
                int cant = Integer.parseInt(request.getParameter("autor"));
                int canti = Integer.parseInt(request.getParameter("idioma"));
                
                int ca = Integer.parseInt(request.getParameter("idd"));
                
                rs.setIsbn(isbn);
                rs.setNombre(nombre);
                rs.setCantidad_pagina(cantidad);
                rs.setIdioma_id(canti);
                rs.setAutor_id(cant);
                rs.setCreado_por(ca);
                rs.save();
                response.sendRedirect("Libro/index.jsp");
                
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
