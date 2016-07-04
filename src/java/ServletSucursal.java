
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Sucursal;

@WebServlet(urlPatterns = {"/ServletSucursal"})
public class ServletSucursal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Sucursal su = new Sucursal();
            if (request.getParameter("eliminar") != null) {
                int eliminar_id = Integer.parseInt(request.getParameter("eliminar"));
                su.setSucursal_id(eliminar_id);
                su.delete();
                response.sendRedirect("Sucursal/index.jsp");

            } else if (request.getParameter("editar") != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                int idus = Integer.parseInt(request.getParameter("idd"));

                String nombre = request.getParameter("nombre");
                su.setNombre(nombre);
                su.setSucursal_id(id);
                su.setCreado_por(idus);
                su.update();

                response.sendRedirect("Sucursal/index.jsp");
            } else {
                String nombre = request.getParameter("nombre");
                int idus = Integer.parseInt(request.getParameter("idd"));

                su.setNombre(nombre);
                su.setCreado_por(idus);
                su.save();
                response.sendRedirect("Sucursal/index.jsp");

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
