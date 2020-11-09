/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ConexionJDBC;
import Modelo.Pago;
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
@WebServlet(name = "Pagos", urlPatterns = {"/Pagos"})
public class Pagos extends HttpServlet {

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
//            out.println("<title>Servlet Pagos</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Pagos at " + request.getContextPath() + "</h1>");
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
        int idSocio = Integer.parseInt(request.getParameter("idSocio"));

        Socio nuevoSocio = gestor.getSocioPago(idSocio);
        
        float montoAPagar = gestor.calcularMontoAPagar(idSocio);
        
        request.setAttribute("socio", nuevoSocio);
        request.setAttribute("monto", montoAPagar);

        RequestDispatcher rd = request.getRequestDispatcher("/registrarPago.jsp");
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
        
        ConexionJDBC gestor = new ConexionJDBC();
        int idSocio = Integer.parseInt(request.getParameter("idSocio"));
        int idCuota = Integer.parseInt(request.getParameter("idCuota"));
        float monto = Float.parseFloat(request.getParameter("monto"));
        String fechaPago = request.getParameter("fechaPago");
        String fechaVencimiento = request.getParameter("fechaVencimiento");
        
        Pago nuevoPago = new Pago(idCuota, idSocio, monto, fechaPago, fechaVencimiento);
        gestor.registrarPago(nuevoPago);
        
        RequestDispatcher rd = request.getRequestDispatcher("/mensajePagoExitoso.jsp");
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
