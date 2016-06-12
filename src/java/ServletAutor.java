
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Autor;

@WebServlet(urlPatterns = {"/ServletAutor"})
public class ServletAutor extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Autor autor = new Autor();

            if (request.getParameter("eliminar") != null) {
                int eliminar_id = Integer.parseInt(request.getParameter("eliminar"));
                autor.setAutor_id(eliminar_id);
                autor.delete();
                response.sendRedirect("Autor/index.jsp");

            } else if (request.getParameter("editar") != null) {

                int id = Integer.parseInt(request.getParameter("id"));
                String nombre = request.getParameter("nombre");
                autor.setNombre(nombre);
                autor.setAutor_id(id);

                autor.update();

                response.sendRedirect("Autor/index.jsp");
            } else {
                String nombre = request.getParameter("nombre");

                autor.setNombre(nombre);
                autor.save();
                response.sendRedirect("Autor/index.jsp");

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
