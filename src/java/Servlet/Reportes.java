/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ConexionJDBC;
import Modelo.Actividad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Reportes", urlPatterns = {"/Reportes"})
public class Reportes extends HttpServlet {

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
//            out.println("<title>Servlet Reportes</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Reportes at " + request.getContextPath() + "</h1>");
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

        request.setAttribute("comboActividades", gestor.getActividades());
        request.setAttribute("comboSocios", gestor.getComboSocio());

        if (modo == null || modo.isEmpty()) {

            RequestDispatcher rd = request.getRequestDispatcher("/reporte.jsp");
            rd.forward(request, response);

        } else if (modo.equals("1")) { //Monto total de ganancias en cuotas
            double montoTotalCuotas = gestor.montoTotalGananciasEnCuotas();
            request.setAttribute("monto", montoTotalCuotas);

            RequestDispatcher rd = request.getRequestDispatcher("/montoGananciasRepo.jsp");
            rd.forward(request, response);

        } else if (modo.equals("2")) { //- Nombre y total de ganancias de las 3 actividades con mayor ganancia total.

            RequestDispatcher rd = request.getRequestDispatcher("/nombreTop3Repo.jsp");
            rd.forward(request, response);
        } else if (modo.equals("3")) {//- Listado de socios inscriptos a una actividad en particular
            int idActividad = Integer.parseInt(request.getParameter("idActividad"));

            request.setAttribute("lista", gestor.getListadoSociosInscriptosActividadParticular(idActividad));
            RequestDispatcher rd = request.getRequestDispatcher("/listaSociosActividadRepo.jsp");
            rd.forward(request, response);

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

        ConexionJDBC gestor = new ConexionJDBC();
        String socio= request.getParameter("socio") ;
        String actividad= request.getParameter("actividad") ;
        
        if (socio == null ||socio.isEmpty() ) { 
             int idActividad = Integer.parseInt(actividad);
        request.setAttribute("actividad_id", idActividad);
        request.setAttribute("lista", gestor.getListadoSociosInscriptosActividadParticular(idActividad));
            RequestDispatcher rd = request.getRequestDispatcher("/listaSociosActividadRepo.jsp");
            rd.forward(request, response);
            
        } else if(actividad== null ||actividad.isEmpty() ){
             int idSocio = Integer.parseInt(socio);
        request.setAttribute("socio_id", idSocio);
        request.setAttribute("lista", gestor.listadoSocioCuotasPagas(idSocio));
            RequestDispatcher rd = request.getRequestDispatcher("/socioCuotasPagasRepo.jsp");
            rd.forward(request, response);
        }
       
       RequestDispatcher rd = request.getRequestDispatcher("/reporte.jsp");
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
