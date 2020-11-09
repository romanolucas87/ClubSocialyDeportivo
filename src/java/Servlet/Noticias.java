/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ConexionJDBC;
import Modelo.Actividad;
import Modelo.Noticia;
import Modelo.Socio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

/**
 *
 * @author Lucas
 */
@WebServlet(name = "Noticias", urlPatterns = {"/Noticias"})
public class Noticias extends HttpServlet {

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
//            out.println("<title>Servlet Noticias</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Noticias at " + request.getContextPath() + "</h1>");
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
        String modo = request.getParameter("modo");

        if (modo == null || modo.isEmpty()) {
            ArrayList<Noticia> lista = gestor.getNoticias();
            request.setAttribute("noticias", lista);
            RequestDispatcher rd =request.getRequestDispatcher("/listadoNoticiasAdmin.jsp");
            rd.forward(request, response);
            
        } else if (modo.equals("accion")) {
            int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
          
            ArrayList<Noticia> lista = gestor.getNoticias();
            gestor.habilitarNoticia(idNoticia);
            RequestDispatcher rd = request.getRequestDispatcher("/listadoNoticiasAdmin.jsp");
            request.setAttribute("noticias", lista);
           
            rd.forward(request, response);
        } else if (modo.equals("agregar")){
            response.sendRedirect("altaNoticia.jsp");
           
        }
        
        
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

        int IdActividad = Integer.parseInt(request.getParameter("idActividad"));

        String descripcionNoticia = request.getParameter("descripcionNoticia");

        Actividad nuevaActividad = new Actividad();
        nuevaActividad.setIdActividad(IdActividad);

        Noticia nuevaNoticia = new Noticia(nuevaActividad, descripcionNoticia, true);
        ConexionJDBC gestor = new ConexionJDBC();
        gestor.cargarNoticia(nuevaNoticia);

        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/listadoNoticiasAdmin.jsp");
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
