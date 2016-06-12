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
import negocio.Usuario;

/**
 *
 * @author XM21
 */
@WebServlet(urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

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
                 Usuario rs = new Usuario();

            if (request.getParameter("eliminar") != null) {
                int eliminar_id = Integer.parseInt(request.getParameter("eliminar"));
                rs.setUsuario_id(eliminar_id);
                rs.delete();
            
                response.sendRedirect("Usuario/index.jsp");


            } else if (request.getParameter("editar") != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("user");
                String pass = request.getParameter("pass");
                rs.setUser(nombre);
                rs.setClave(pass);
                rs.setUsuario_id(id);

                rs.update();

                
                response.sendRedirect("Usuario/index.jsp");

            } else {
                String nombre = request.getParameter("user");
                String pass = request.getParameter("pass");

                rs.setUser(nombre);
                rs.setClave(pass);
                rs.save();
                
                response.sendRedirect("Usuario/index.jsp");

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
