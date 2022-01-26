/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import DTO.DTOFacturacion;
import DTO.DTOObtenerDetalleFactura;
import DTO.DTOObtenerFactura;
import DTO.DTORankingFacturacion;
import DTO.DTOVentasXEmpleado;
import Model.Cliente;
import Model.DetalleFactura;
import Model.Empleado;
import Model.Factura;
import Model.Marca;
import Model.Producto;
import Model.Sucursal;
import Model.TipoPago;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class GestorReportes {

    private final String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLab4";
    private final String user = "sa";
    private final String pass = "Gmb+1992";

    public GestorReportes() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// - Listado de facturación para un día en particular.
    public ArrayList<DTOObtenerFactura> obtenerFacturasXFecha(Date fecha) {

        ArrayList<DTOObtenerFactura> lst = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement("select f.cod_venta, fecha, nom_cli, nom_emp, nom_sucusal , sum(importeTotal) as ImporteTotal from Facturas f "
                        + " JOIN DetalleFacturas d on d.cod_venta=f.cod_venta "
                        + " join  Empleados e on e.cod_emp = f.cod_emp join Clientes c on f.cod_cli= c.cod_cli "
                        + "join Sucursales s on s.cod_sucursal = f.cod_sucursal "
                        + "where fecha = ? "
                        + " group by f.cod_venta, fecha, nom_cli, nom_emp, nom_sucusal ")) {

            ps.setDate(1, fecha);
            rs = ps.executeQuery();

            while (rs.next()) {

                DTOObtenerFactura fa = new DTOObtenerFactura();
                fa.setCod_venta(rs.getInt("cod_venta"));
                fa.setFecha(rs.getDate("fecha"));
                fa.setCliente(rs.getString("nom_cli"));
                fa.setEmpleado(rs.getString("nom_emp"));
                fa.setSucursal(rs.getString("nom_sucusal"));
                fa.setImporteTotal(rs.getString("ImporteTotal"));

                lst.add(fa);
            }
            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;
    }

    public ArrayList<DTOObtenerFactura> obtenerFacturasXFechaSucursal(Date fecha, int cod_sucursal) {

        ArrayList<DTOObtenerFactura> lst = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement("select f.cod_venta, fecha, nom_cli, nom_emp, nom_sucusal , sum(importeTotal) ImporteTotal from Facturas f "
                        + "JOIN DetalleFacturas d on d.cod_venta=f.cod_venta "
                        + "join Empleados e on e.cod_emp = f.cod_emp "
                        + "join Clientes c on f.cod_cli= c.cod_cli"
                        + " join Sucursales s on s.cod_sucursal = f.cod_sucursal"
                        + " where fecha = ? and f.cod_sucursal = ? "
                        + "group by f.cod_venta, fecha, nom_cli, nom_emp, nom_sucusal ")) {

            ps.setDate(1, fecha);
            ps.setInt(2, cod_sucursal);
            rs = ps.executeQuery();

            while (rs.next()) {

                DTOObtenerFactura fa = new DTOObtenerFactura();
                fa.setCod_venta(rs.getInt("cod_venta"));
                fa.setFecha(rs.getDate("fecha"));
                fa.setCliente(rs.getString("nom_cli"));
                fa.setEmpleado(rs.getString("nom_emp"));
                fa.setSucursal(rs.getString("nom_sucusal"));
                fa.setImporteTotal(rs.getString("ImporteTotal"));

                lst.add(fa);
            }
            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;
    }
    // REPORTE 2 
    // - Listado de facturación para un día en particular y para una sucursal seleccionada

    public ArrayList<Factura> obtenerFacturasXFechaySucursal(Date fecha, int cod_sucursal) {

        ArrayList<Factura> lst = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement("select * from Facturas WHERE fecha = ? and f.cod_sucursal = ? ")) {

            ps.setDate(1, fecha);
            ps.setInt(2, cod_sucursal);

            rs = ps.executeQuery();

            while (rs.next()) {

                Factura f = new Factura();
                f.setCod_venta(rs.getInt("cod_venta"));
                f.setFecha(rs.getDate("fecha"));

                Cliente c = new Cliente();
                int cli = rs.getInt("cod_cli");
                c.setCod_cli(cli);
                f.setCliente(c);

                Empleado e = new Empleado();
                int emp = rs.getInt("cod_emp");
                e.setCod_emp(emp);
                f.setEmpleado(e);

                Sucursal s = new Sucursal();
                int sus = rs.getInt("cod_sucursal");
                s.setCod_sucursal(sus);
                f.setSucursal(s);

                lst.add(f);
            }

            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;
    }

    // - Total de facturación para un rango de fechas, en general para la empresa y discriminando por sucursal.
    public ArrayList<DTOObtenerFactura> obtenerFacturasEntreFechas(Date fecha1, Date fecha2) {

        ArrayList<DTOObtenerFactura> lstDTO = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement("select  s.cod_sucursal as cod, nom_sucusal , sum(importeTotal) ImporteTotal from Facturas f "
                        + "JOIN DetalleFacturas d on d.cod_venta=f.cod_venta "
                        + "join  Empleados e on e.cod_emp = f.cod_emp "
                        + "join Clientes c on f.cod_cli= c.cod_cli "
                        + "join Sucursales s on s.cod_sucursal = f.cod_sucursal "
                        + "where fecha between ? and ? "
                        + "group by nom_sucusal, s.cod_sucursal  ")) {

            ps.setDate(1, fecha1);
            ps.setDate(2, fecha2);

            rs = ps.executeQuery();

            while (rs.next()) {

                DTOObtenerFactura fa = new DTOObtenerFactura();
                fa.setSucursal(rs.getString("nom_sucusal"));
                fa.setImporteTotal(rs.getString("ImporteTotal"));
                fa.setCod_venta(rs.getInt("cod"));
                lstDTO.add(fa);

            }

            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lstDTO;
    }

    // - Total de facturación para un rango de fechas, en general para la empresa y discriminando por sucursal.
    public ArrayList<DTOFacturacion> obtenerReporte3Bis() {

        ArrayList<DTOFacturacion> lstDTO = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement("select f.cod_sucursal as CodSucursal, s.nom_sucusal as NombreSucursal, sum(importeTotal) as FacturacionTotal from Facturas f "
                        + "JOIN DetalleFacturas d on d.cod_venta=f.cod_venta "
                        + "JOIN Productos p on p.cod_pro=d.cod_pro "
                        + "JOIN Sucursales s on p.cod_sucursal=s.cod_sucursal "
                        + "group by f.cod_sucursal , s.nom_sucusal")) {

            rs = ps.executeQuery();

            while (rs.next()) {

                DTOFacturacion dto = new DTOFacturacion();
                dto.setCod_sucursal(rs.getInt("CodSucursal"));
                dto.setNom_sucusal(rs.getString("NombreSucursal"));
                dto.setImporteTotal(rs.getFloat("FacturacionTotal"));

                lstDTO.add(dto);

            }

            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lstDTO;
    }

    // - Detalle de una factura identificada por número.
    public ArrayList<DTOObtenerDetalleFactura> obtenerDetalleXFactura(int cod_detalleVenta) {

        ArrayList<DTOObtenerDetalleFactura> lst = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement(" select cod_detalleVenta, cod_venta , descripcion, pre_compra,venta_libre, cantidad, precio_unitario, nom_form_pago, importeTotal  "
                        + "from DetalleFacturas dt join tipoPagos tp on tp.cod_tipoPago = dt.cod_tipoPago join Productos p on p.cod_pro = dt.cod_pro  where cod_venta = ?")) {

            ps.setInt(1, cod_detalleVenta);
            rs = ps.executeQuery();

            while (rs.next()) {
                DTOObtenerDetalleFactura df = new DTOObtenerDetalleFactura();
                df.setCod_detalleVenta(rs.getInt("cod_detalleVenta"));
                df.setFactura(rs.getInt("cod_venta"));
                df.setProducto(rs.getString("descripcion"));
                df.setCantidad(rs.getInt("cantidad"));
                df.setPrecio_unitario(rs.getFloat("precio_unitario"));
                df.setTipoPago(rs.getString("nom_form_pago"));
                df.setImporteTotal(rs.getFloat("importeTotal"));

                lst.add(df);

            }
            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lst;
    }

    // - Ranking de los 20 suministros de mayor facturación, ordenados en forma decreciente por importe total
    public ArrayList<DTORankingFacturacion> obtenerTop20Facturacion() {
        ArrayList<DTORankingFacturacion> lstTop20 = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement sta = cnn.createStatement()) {

            rs = sta.executeQuery("select TOP 20 descripcion, importeTotal from Productos p "
                    + "JOIN DetalleFacturas d on d.cod_pro=p.cod_pro "
                    + "order by importeTotal desc");

            while (rs.next()) {
                DTORankingFacturacion dto = new DTORankingFacturacion();
                dto.setDescripcion(rs.getString("descripcion"));
                dto.setImporteTotal(rs.getFloat("importeTotal"));

                lstTop20.add(dto);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lstTop20;
    }

    // - Cantidad de ventas por empleado.
    public ArrayList<DTOVentasXEmpleado> obtenerVentasXEmpleado() {
        ArrayList<DTOVentasXEmpleado> lstDTO = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement sta = cnn.createStatement()) {

            rs = sta.executeQuery("select f.cod_emp as CodigoEmpleado, e.nom_emp as NombreEmpleado , count(cod_venta) as CantidadVentas from Facturas f "
                    + "JOIN Empleados e on f.cod_emp=e.cod_emp "
                    + "GROUP BY f.cod_emp , e.nom_emp");

            while (rs.next()) {
                DTOVentasXEmpleado dto = new DTOVentasXEmpleado();
                dto.setCod_emp(rs.getInt("CodigoEmpleado"));
                dto.setNom_emp(rs.getString("NombreEmpleado"));
                dto.setCod_venta(rs.getInt("CantidadVentas"));

                lstDTO.add(dto);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso a datos!");
        }
        return lstDTO;
    }

    //-----------------------------------------------------------------------------------------
    public ArrayList<Producto> listado() {
        ArrayList<Producto> lista = new ArrayList<>();
        //lista.add(new Servicio(1, "dfdf", "dfcv", 999));
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(user, user, pass);
            st = conn.createStatement();
            rs = st.executeQuery("select cod_pro , descripcion from Productos");

            while (rs.next()) {
                Producto p = new Producto();
                p.setCod_pro(rs.getInt("cod_pro"));
                p.setDescripcion(rs.getString("descripcion"));

                lista.add(p);
            }
            rs.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("E " + e);
        }
        return lista;
    }

    public ArrayList<DTOFacturacion> obtenerTotalPorDetalle() {

        ArrayList<DTOFacturacion> lstDTO = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement("select sum(importeTotal) as FacturacionTotal from Facturas f "
                        + "JOIN DetalleFacturas d on d.cod_venta=f.cod_venta "
                        + "JOIN Productos p on p.cod_pro=d.cod_pro "
                        + "JOIN Sucursales s on p.cod_sucursal=s.cod_sucursal "
                        + "group by f.cod_venta ")) {

            rs = ps.executeQuery();

            while (rs.next()) {

                DTOFacturacion dto = new DTOFacturacion();
                dto.setImporteTotal(rs.getFloat("FacturacionTotal"));

                lstDTO.add(dto);
            }

            rs.close();
            conn3.close();
        } catch (SQLException ex) {
            System.out.println("Error de acceso a datos!");
        }
        return lstDTO;
    }

}
