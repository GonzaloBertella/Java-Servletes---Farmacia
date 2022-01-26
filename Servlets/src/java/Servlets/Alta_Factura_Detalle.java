/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.DTOClienteBarrio;
import DTO.DTOEmpleadoBarrio;
import DTO.DTOObtenerDetalleFactura;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author gonza
 */
@WebServlet(name = "Alta_Factura_Detalle", urlPatterns = {"/Alta_Factura_Detalle"})
public class Alta_Factura_Detalle extends HttpServlet {

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

        // DETALLE DE FACTURA
        GestorParaListados controlador5 = new GestorParaListados();
        List<DTOProductoMarcaProveedorCategoria> listaProducto = controlador5.obtenerProductos();
        request.setAttribute("listaProducto", listaProducto);

        GestorParaListados controlador6 = new GestorParaListados();
        List<TipoPago> listaTipoPago = controlador6.obtenerTipoPago();
        request.setAttribute("listaTipoPago", listaTipoPago);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Alta_Factura_Detalle.jsp");
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

        HttpSession s = request.getSession();
        ArrayList<DetalleFactura> lstDetalle = (ArrayList<DetalleFactura>) s.getAttribute("lstDetalle");
        if (lstDetalle == null) {
            lstDetalle = new ArrayList<>();
        }

        //INSERTAR DETALLE
        int cod_pro = Integer.parseInt(request.getParameter("cboProducto"));
        Producto pro = new Producto();
        pro.setCod_pro(cod_pro);

        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
        int precio_unitario = Integer.parseInt(request.getParameter("txtPrecioUnitario"));

        int cod_tipoPago = Integer.parseInt(request.getParameter("cboTipoPago"));
        TipoPago tp = new TipoPago();
        tp.setCod_tipoPago(cod_tipoPago);

        DetalleFactura df = new DetalleFactura();
        df.setProducto(pro);
        df.setCantidad(cantidad);
        df.setPrecio_unitario(precio_unitario);
        df.setTipoPago(tp);

        float importeTotal = 0;
        if (cod_tipoPago == 1) {
            importeTotal = (precio_unitario * cantidad) * (float) 1.25;
        } else {
            importeTotal = (precio_unitario * cantidad) - ((precio_unitario * cantidad) * (float) 0.10);
        }
        df.setImporteTotal(importeTotal);

        lstDetalle.add(df);
        s.setAttribute("lstDetalle", lstDetalle);

        response.sendRedirect("/Parcial2Lab4/Alta_Factura");
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
