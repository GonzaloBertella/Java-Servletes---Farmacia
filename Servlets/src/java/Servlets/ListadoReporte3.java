/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;


import DTO.DTOFacturacion;
import DTO.DTOObtenerFactura;
import Gestores.GestorReportes;
import Model.Factura;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gonza
 */
@WebServlet(name = "ListadoReporte3", urlPatterns = {"/ListadoReporte3"})
public class ListadoReporte3 extends HttpServlet {

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
        
        String dateStr = request.getParameter("txtFecha");
        String dateStr2 = request.getParameter("txtFecha2");
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date resultado = formater.parse(dateStr);
            java.sql.Date fecha = new java.sql.Date(resultado.getTime());
             Date resultado2 = formater.parse(dateStr2);
            java.sql.Date fecha2= new java.sql.Date(resultado2.getTime());
            
            GestorReportes gestor = new GestorReportes();
            List<DTOObtenerFactura> lista = gestor.obtenerFacturasEntreFechas(fecha, fecha2);

            request.setAttribute("lst", lista);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoReporte3bis.jsp");
            dispatcher.forward(request, response);

        } catch (ParseException e) {

            e.printStackTrace();

        }

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
