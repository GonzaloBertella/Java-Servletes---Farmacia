/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import DTO.DTOProveedorBarrio;
import Gestores.GestorAltas;
import Gestores.GestorParaListados;
import Model.Categoria;
import Model.Marca;
import Model.Producto;
import Model.Proveedor;
import Model.Sucursal;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Alta_Producto", urlPatterns = {"/Alta_Producto"})
public class Alta_Producto extends HttpServlet {

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
        List<Marca> listaMarca = controlador.obtenerMarca();
        request.setAttribute("listaMarca", listaMarca);

        GestorParaListados controlador2 = new GestorParaListados();
        List<Categoria> listaCategoria = controlador2.obtenerCategoria();
        request.setAttribute("listaCategoria", listaCategoria);

        GestorParaListados controlador3 = new GestorParaListados();
        List<Sucursal> listaSucursal = controlador3.obtenerSucursal();
        request.setAttribute("listaSucursal", listaSucursal);

        GestorParaListados controlador4 = new GestorParaListados();
        List<DTOProveedorBarrio> listaProveedor = controlador4.obtenerProveedores();
        request.setAttribute("listaProveedor", listaProveedor);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Alta_Producto.jsp");
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

        String descripcion = request.getParameter("txtDescripcion");
        int pre_compra = Integer.parseInt(request.getParameter("txtPrecioCompra"));

        PrintWriter out = response.getWriter();

        String dateStr = request.getParameter("txtFechaVencimiento");
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date  resultado = formater.parse(dateStr);
            java.sql.Date fecha_venc = new java.sql.Date(resultado.getTime());

            int cod_marca = Integer.parseInt(request.getParameter("cboMarca"));
            int cod_prov = Integer.parseInt(request.getParameter("cboProveedor"));
            int cod_categoria = Integer.parseInt(request.getParameter("cboCategoria"));

            boolean venta_libre = Boolean.parseBoolean("txtVentaLibre");
            int stock = Integer.parseInt(request.getParameter("txtStock"));

            int cod_sucursal = Integer.parseInt(request.getParameter("cboSucursal"));

            Marca m = new Marca();

            m.setCod_marca(cod_marca);

            Proveedor p = new Proveedor();

            p.setCod_prov(cod_prov);

            Categoria c = new Categoria();

            c.setCod_categoria(cod_categoria);

            Sucursal s = new Sucursal();

            s.setCod_sucursal(cod_sucursal);

            Producto pro = new Producto(descripcion, pre_compra, fecha_venc, m, p, c,!venta_libre, stock, s);
            GestorAltas gestor = new GestorAltas();

            gestor.registrarProducto(pro);
        } catch (ParseException e) {

            e.printStackTrace();

        }

          response.sendRedirect("/Parcial2Lab4/ListadoProductos");
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
