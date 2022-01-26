/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Gestores.GestorAltas;
import Gestores.GestorParaListados;
import Model.Barrio;
import Model.Proveedor;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Alta_Proveedor", urlPatterns = {"/Alta_Proveedor"})
public class Alta_Proveedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

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
     
         GestorParaListados controlador = new GestorParaListados();
        List<Barrio> listaBarrio = controlador.obtenerBarrio();
        request.setAttribute("listaBarrio", listaBarrio);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Alta_Proveedor.jsp");
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
       
        
        String nom_prov = request.getParameter("txtNombre");
        String dir_prov = request.getParameter("txtDireccion");
        int cod_barrio = Integer.parseInt(request.getParameter("cboBarrio"));
        
        Barrio ba = new Barrio();
        ba.setCod_barrio(cod_barrio);
        
        String telefono= request.getParameter("txtTelefono");
        
        Proveedor prov = new Proveedor(nom_prov, dir_prov, ba, telefono);
        GestorAltas gestor = new GestorAltas();
        gestor.registrarProveedor(prov);
        
        response.sendRedirect("/Parcial2Lab4/ListadoProveedores");
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
