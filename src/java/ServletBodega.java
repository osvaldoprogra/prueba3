
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Bodega;

@WebServlet(urlPatterns = {"/ServletBodega"})
public class ServletBodega extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Bodega bo = new Bodega();
            if (request.getParameter("eliminar") != null) {
                int eliminar_id = Integer.parseInt(request.getParameter("eliminar"));
                bo.setBodega_id(eliminar_id);
                bo.delete();
                response.sendRedirect("Bodega/index.jsp");

            } else if (request.getParameter("editar") != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                int id1 = Integer.parseInt(request.getParameter("Sucursal_id"));
                int idus = Integer.parseInt(request.getParameter("idd"));
                bo.setCreado_por(idus);
                bo.setNombre(nombre);
                bo.setBodega_id(id);
                bo.setSucursal_id(id1);
                bo.update();

                response.sendRedirect("Bodega/index.jsp");
            } else {
                String nombre = request.getParameter("nombre");
                int id = Integer.parseInt(request.getParameter("Sucursal_id"));
                int idus = Integer.parseInt(request.getParameter("idd"));

                bo.setNombre(nombre);
                bo.setSucursal_id(id);
                bo.setCreado_por(idus);
                bo.save();
                response.sendRedirect("Bodega/index.jsp");

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
