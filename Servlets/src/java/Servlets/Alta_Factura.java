/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.DTOClienteBarrio;
import DTO.DTOEmpleadoBarrio;
import DTO.DTOObtenerFactura;
import DTO.DTOProductoMarcaProveedorCategoria;
import DTO.DTOProveedorBarrio;
import Gestores.GestorAltas;
import Gestores.GestorParaListados;
import Model.Cliente;
import Model.DetalleFactura;
import Model.Empleado;
import Model.Factura;
import Model.Producto;
import Model.Sucursal;
import Model.TipoPago;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
@WebServlet(name = "Alta_Factura", urlPatterns = {"/Alta_Factura"})
public class Alta_Factura extends HttpServlet {

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

        GestorParaListados controlador2 = new GestorParaListados();
        List<DTOClienteBarrio> listaCliente = controlador2.obtenerClientes();
        request.setAttribute("listaCliente", listaCliente);

        GestorParaListados controlador3 = new GestorParaListados();
        List<DTOEmpleadoBarrio> listaEmpleado = controlador3.obtenerEmpleado();
        request.setAttribute("listaEmpleado", listaEmpleado);

        GestorParaListados controlador4 = new GestorParaListados();
        List<Sucursal> listaSucursal = controlador4.obtenerSucursal();
        request.setAttribute("listaSucursal", listaSucursal);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Alta_Factura.jsp");
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

        PrintWriter out = response.getWriter();

        String dateStr = request.getParameter("txtFecha");
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date resultado = formater.parse(dateStr);
            java.sql.Date fecha = new java.sql.Date(resultado.getTime());

            int cod_cli = Integer.parseInt(request.getParameter("cboCliente"));
            Cliente c = new Cliente();
            c.setCod_cli(cod_cli);

            int cod_empleado = Integer.parseInt(request.getParameter("cboEmpleado"));
            Empleado em = new Empleado();
            em.setCod_emp(cod_empleado);

            int cod_sucursal = Integer.parseInt(request.getParameter("cboSucursal"));
            Sucursal su = new Sucursal();
            su.setCod_sucursal(cod_sucursal);

            Factura v = new Factura();
            v.setFecha(fecha);
            v.setCliente(c);
            v.setEmpleado(em);
            v.setSucursal(su);

            GestorAltas gestor = new GestorAltas();
            ArrayList<DetalleFactura> lstDetalle = (ArrayList<DetalleFactura>) request.getSession().getAttribute("lstDetalle");
            if (lstDetalle != null) {
                 int cod_venta = gestor.registrarFactura(v, lstDetalle);
                 request.getSession().removeAttribute("lstDetalle");
            }


        } catch (ParseException e) {

            e.printStackTrace();

        }
        
         response.sendRedirect("/Parcial2Lab4/ListadoFacturas");
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
