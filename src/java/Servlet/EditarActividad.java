/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ConexionJDBC;
import Modelo.Actividad;
import Modelo.Socio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "EditarActividad", urlPatterns = {"/EditarActividad"})
public class EditarActividad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet EditarActividad</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet EditarActividad at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
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
        ConexionJDBC gestor = new ConexionJDBC();
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        Actividad nuevaActividad = gestor.getActividadId(idActividad);
        request.setAttribute("modeloActividad", nuevaActividad); 

        RequestDispatcher rd = request.getRequestDispatcher("/editarActividad.jsp");
        rd.forward(request, response);
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
        
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        String nombreActividad = request.getParameter("nombreActividad");
        double precioActividad = Double.parseDouble(request.getParameter("precioActividad"));
        
        Actividad nuevaActividad = new Actividad(idActividad, nombreActividad, precioActividad, true);
        
        ConexionJDBC gestor = new ConexionJDBC();
        gestor.modificarActividad(nuevaActividad);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/listadoActividades.jsp");
        rd.forward(request, response);
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
