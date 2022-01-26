/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.DTOObtenerFactura;
import Gestores.GestorParaListados;
import Gestores.GestorReportes;
import Model.Factura;
import Model.Sucursal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ListadoReporte2", urlPatterns = {"/ListadoReporte2"})
public class ListadoReporte2 extends HttpServlet {

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

        GestorParaListados controlador3 = new GestorParaListados();
        List<Sucursal> listaSucursal = controlador3.obtenerSucursal();
        request.setAttribute("listaSucursal", listaSucursal);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoReporte2.jsp");
        dispatcher.forward(request, response);

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
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date resultado = formater.parse(dateStr);
            java.sql.Date fecha = new java.sql.Date(resultado.getTime());

            int cod_sucursal = Integer.parseInt(request.getParameter("cboSucursal"));
            GestorReportes gestor = new GestorReportes();
            List<DTOObtenerFactura> lista = gestor.obtenerFacturasXFechaSucursal(fecha, cod_sucursal);
            request.setAttribute("lst", lista);
            

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListadoFacturas.jsp");
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
