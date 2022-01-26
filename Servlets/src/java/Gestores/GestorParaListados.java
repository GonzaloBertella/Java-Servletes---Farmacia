/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import DTO.DTOClienteBarrio;
import DTO.DTOEmpleadoBarrio;
import DTO.DTOObtenerDetalleFactura;
import DTO.DTOObtenerFactura;
import DTO.DTOObtenerFactura2;
import DTO.DTOProductoMarcaProveedorCategoria;
import DTO.DTOProveedorBarrio;
import Model.Barrio;
import Model.Categoria;
import Model.Cliente;
import Model.DetalleFactura;
import Model.Empleado;
import Model.Factura;
import Model.Localidad;
import Model.Marca;
import Model.Producto;
import Model.Proveedor;
import Model.Sucursal;
import Model.TipoPago;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class GestorParaListados {

    private final String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLab4";
    private final String user = "sa";
    private final String pass = "Gmb+1992";

    public GestorParaListados() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorParaListados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // OBTENER SUCURSAL
    public List<Sucursal> obtenerSucursal() {
        List<Sucursal> lstSucursal = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" SELECT  * from Sucursales ");
            while (rs.next()) {
                Sucursal su = new Sucursal();

                su.setCod_sucursal(rs.getInt("cod_sucursal"));
                su.setNom_sucursal(rs.getString("nom_sucusal"));
                su.setDireccion(rs.getString("direccion"));
                su.setTelefono(rs.getString("telefono"));

                lstSucursal.add(su);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la Sucursal !");
        }
        return lstSucursal;
    }
//OBTENER BARRIO

    public List<Barrio> obtenerBarrio() {
        List<Barrio> lstBarrio = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" SELECT  * from Barrios ");
            while (rs.next()) {
                Barrio ba = new Barrio();
                ba.setCod_barrio(rs.getInt("cod_barrio"));
                ba.setBarrio(rs.getString("Barrio"));

                Localidad d = new Localidad();
                int loc = rs.getInt("cod_localidad");
                d.setCod_localidad(loc);
                ba.setLocalidad(d);

                lstBarrio.add(ba);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Barrio !");
        }
        return lstBarrio;
    }

    //OBTENER CATEGORIA
    public List<Categoria> obtenerCategoria() {
        List<Categoria> lstCategoria = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" SELECT  * from Categorias ");
            while (rs.next()) {
                Categoria ca = new Categoria();
                ca.setCod_categoria(rs.getInt("cod_categoria"));
                ca.setDescripcion(rs.getString("descripcion"));

                lstCategoria.add(ca);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la Categoria !");
        }
        return lstCategoria;
    }

    //OBTENER  MARCA
    public List<Marca> obtenerMarca() {
        List<Marca> lstMarca = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" SELECT  * from Marcas ");
            while (rs.next()) {
                Marca ma = new Marca();
                ma.setCod_marca(rs.getInt("cod_marca"));
                ma.setDescripcion(rs.getString("descripcion"));

                lstMarca.add(ma);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener la Marca !");
        }
        return lstMarca;
    }

    //OBTENER TIPO DE PAGO
    public List<TipoPago> obtenerTipoPago() {
        List<TipoPago> lstTipoPago = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" SELECT  * from TipoPagos ");
            while (rs.next()) {
                TipoPago tp = new TipoPago();
                tp.setCod_tipoPago(rs.getInt("cod_tipoPago"));
                tp.setNom_form_pago(rs.getString("nom_form_pago"));

                lstTipoPago.add(tp);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Tipo de Pago !");
        }
        return lstTipoPago;
    }

    // OBTENER CLIENTES
    public List<DTOClienteBarrio> obtenerClientes() {
        List<DTOClienteBarrio> lstCliente = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" SELECT  cod_cli , nom_cli , dir_cli , DNI , telefono, barrio  from Clientes  c  join Barrios b  on c.cod_barrio=b.cod_barrio ");
            while (rs.next()) {
                DTOClienteBarrio cli = new DTOClienteBarrio();
                cli.setCod_cli(rs.getInt("cod_cli"));
                cli.setNom_cli(rs.getString("nom_cli"));
                cli.setDir_cli(rs.getString("dir_cli"));
                cli.setBarrio(rs.getString("barrio"));
                cli.setDNI(rs.getInt("DNI"));
                cli.setTelefono(rs.getString("telefono"));

                lstCliente.add(cli);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Cliente !");
        }
        return lstCliente;
    }

    // OBTENER CLIENTE POR ID
    public DTOClienteBarrio obtenerPorId(int DNI) {
        ResultSet rs = null;
        DTOClienteBarrio c = new DTOClienteBarrio();
        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn.prepareStatement("SELECT  cod_cli , nom_cli , dir_cli , DNI , telefono, barrio  from Clientes  c "
                        + " join Barrios b  on c.cod_barrio=b.cod_barrio where dni = ?")) {
            ps.setInt(1, DNI);

            rs = ps.executeQuery();
            if (rs.next()) {
                c.setCod_cli(rs.getInt("cod_cli"));
                c.setNom_cli(rs.getString("nom_cli"));
                c.setDir_cli(rs.getString("dir_cli"));
                c.setBarrio(rs.getString("barrio"));
                c.setDNI(rs.getInt("DNI"));
                c.setTelefono(rs.getString("telefono"));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error de acceso al Cliente !");
        }
        return c;
    }

    // OBTENER PRODUCTO
    public List<DTOProductoMarcaProveedorCategoria> obtenerProductos() {
        List<DTOProductoMarcaProveedorCategoria> lstProducto = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" Select cod_pro, p.descripcion as producto, pre_compra, fecha_venc, m.descripcion as marca, \n"
                    + "nom_prov, c.descripcion as categoria, venta_libre, stock, s.nom_sucusal as sucursal \n"
                    + "from Productos p \n"
                    + "join Marcas m on p.cod_marca = m.cod_marca \n"
                    + "join Proveedores pv on p.cod_prov = pv.cod_prov \n"
                    + "join Categorias c on p.cod_categoria = c.cod_categoria \n"
                    + "join Sucursales s on p.cod_sucursal = s.cod_sucursal ");

            while (rs.next()) {
                DTOProductoMarcaProveedorCategoria p = new DTOProductoMarcaProveedorCategoria();
                p.setCod_pro(rs.getInt("cod_pro"));
                p.setDescripcion(rs.getString("producto"));
                p.setPre_compra(rs.getInt("pre_compra"));
                p.setFecha_venc(rs.getDate("fecha_venc"));
                p.setMarca(rs.getString("marca"));
                p.setProveedor(rs.getString("nom_prov"));
                p.setCategoria(rs.getString("categoria"));
                p.setVenta_libre(rs.getBoolean("venta_libre"));
                p.setStock(rs.getInt("stock"));
                p.setSucursal(rs.getString("sucursal"));

                lstProducto.add(p);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Producto !");
        }
        return lstProducto;
    }

    //OBTENER PROVEEDOR
    public List<DTOProveedorBarrio> obtenerProveedores() {
        List<DTOProveedorBarrio> lstProveedor = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" select cod_prov, nom_prov,dir_prov,barrio,telefono \n"
                    + "from Proveedores join Barrios on Proveedores.cod_barrio = Barrios.cod_barrio ");
            while (rs.next()) {
                DTOProveedorBarrio pr = new DTOProveedorBarrio();
                pr.setCod_prov(rs.getInt("cod_prov"));
                pr.setNom_prov(rs.getString("nom_prov"));
                pr.setDir_prov(rs.getString("dir_prov"));
                pr.setBarrio(rs.getString("barrio"));
                pr.setTelefono(rs.getString("telefono"));

                lstProveedor.add(pr);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Producto !");
        }
        return lstProveedor;
    }

    //OBTENER EMPLEADO
    public List<DTOEmpleadoBarrio> obtenerEmpleado() {
        List<DTOEmpleadoBarrio> lstEmpleado = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" Select cod_emp, nom_emp, dir_emp, barrio, cargo, edad, tel \n"
                    + "from Empleados e join Barrios b on e.cod_barrio = b.cod_barrio ");
            while (rs.next()) {
                DTOEmpleadoBarrio em = new DTOEmpleadoBarrio();
                em.setCod_emp(rs.getInt("cod_emp"));
                em.setNom_emp(rs.getString("nom_emp"));
                em.setDir_emp(rs.getString("dir_emp"));
                em.setBarrio(rs.getString("barrio"));
                em.setCargo(rs.getString("cargo"));
                em.setEdad(rs.getString("edad"));
                em.setTel(rs.getString("tel"));

                lstEmpleado.add(em);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Producto !");
        }
        return lstEmpleado;
    }

    //OBTENER FACTURAS
//    public List<DTOObtenerFactura> obtenerFactura() {
//        List<DTOObtenerFactura> lstFactura = new ArrayList<>();
//        ResultSet rs = null;
//
//        try (Connection cnn = DriverManager.getConnection(url, user, pass);
//                Statement stm = cnn.createStatement()) {
//
//            rs = stm.executeQuery(" select cod_venta, fecha, nom_cli, nom_emp, nom_sucusal "
//                    + "from Facturas f join Empleados e on e.cod_emp = f.cod_emp join Clientes c on f.cod_cli= c.cod_cli join Sucursales s on s.cod_sucursal = f.cod_sucursal ");
//
//            while (rs.next()) {
//                DTOObtenerFactura fa = new DTOObtenerFactura();
//                fa.setCod_venta(rs.getInt("cod_venta"));
//                fa.setFecha(rs.getDate("fecha"));
//                fa.setCliente(rs.getString("nom_cli"));
//                fa.setEmpleado(rs.getString("nom_emp"));
//                fa.setSucursal(rs.getString("nom_sucusal"));
//
//                lstFactura.add(fa);
//            }
//            rs.close();
//        } catch (SQLException e) {
//            System.out.println("Error al obtener el Producto !");
//        }
//        return lstFactura;
//    }

     //OBTENER FACTURAS CON TOTAL 
    public List<DTOObtenerFactura2> obtenerFactura2() {
        List<DTOObtenerFactura2> lstFactura = new ArrayList<>();
        ResultSet rs = null;

        try (Connection cnn = DriverManager.getConnection(url, user, pass);
                Statement stm = cnn.createStatement()) {

            rs = stm.executeQuery(" select f.cod_venta, f.fecha, nom_cli, nom_emp, nom_sucusal , sum(importeTotal) as ImporteTotal from Facturas f "
                    + "JOIN DetalleFacturas d on d.cod_venta=f.cod_venta"
                    + " join Empleados e on e.cod_emp = f.cod_emp join Clientes c on f.cod_cli= c.cod_cli "
                    + "join Sucursales s on s.cod_sucursal = f.cod_sucursal "
                    + "group by f.cod_venta, f.fecha, nom_cli, nom_emp, nom_sucusal ");

            while (rs.next()) {
                DTOObtenerFactura2 fa = new DTOObtenerFactura2();
                fa.setCod_venta(rs.getInt("cod_venta"));
                fa.setFecha(rs.getDate("fecha"));
                fa.setCliente(rs.getString("nom_cli"));
                fa.setEmpleado(rs.getString("nom_emp"));
                fa.setSucursal(rs.getString("nom_sucusal"));
                fa.setImporteTotal(rs.getString("ImporteTotal"));

                lstFactura.add(fa);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el Producto !");
        }
        return lstFactura;
    }

    //OBTENER DETALLE DE FACTURAS
    public List<DTOObtenerDetalleFactura> obtenerDetalleFactura(int cod_venta) {
        List<DTOObtenerDetalleFactura> lstDetalleFactura = new ArrayList<>();
        ResultSet rs = null;

        try (
                Connection conn3 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = conn3.prepareStatement(" select cod_detalleVenta, cod_venta , descripcion, pre_compra,venta_libre, cantidad, precio_unitario, nom_form_pago, importeTotal \n"
                        + "from DetalleFacturas dt join tipoPagos tp on tp.cod_tipoPago = dt.cod_tipoPago join Productos p on p.cod_pro = dt.cod_pro  where cod_venta = ?")) {

            ps.setInt(1, cod_venta);
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

                lstDetalleFactura.add(df);
            }
            rs.close();
            conn3.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener del Detalle !");
        }
        return lstDetalleFactura;
    }

//   
//    public List<DTOObtenerDetalleFactura> obtenerDetalleFactura2() {
//        List<DTOObtenerDetalleFactura> lstDetalleFactura = new ArrayList<>();
//        ResultSet rs = null;
//
//        try (
//                Connection conn3 = DriverManager.getConnection(url, user, pass);
//                PreparedStatement ps = conn3.prepareStatement(" select cod_detalleVenta, cod_venta , descripcion, pre_compra,venta_libre, cantidad, precio_unitario, nom_form_pago, importeTotal "
//                        + "from DetalleFacturas dt join tipoPagos tp on tp.cod_tipoPago = dt.cod_tipoPago join Productos p on p.cod_pro = dt.cod_pro ")) {
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                DTOObtenerDetalleFactura df = new DTOObtenerDetalleFactura();
//                df.setCod_detalleVenta(rs.getInt("cod_detalleVenta"));
//                df.setFactura(rs.getInt("cod_venta"));
//                df.setProducto(rs.getString("descripcion"));
//                df.setCantidad(rs.getInt("cantidad"));
//                df.setPrecio_unitario(rs.getFloat("precio_unitario"));
//                df.setTipoPago(rs.getString("nom_form_pago"));
//                df.setImporteTotal(rs.getFloat("importeTotal"));
//
//                lstDetalleFactura.add(df);
//            }
//            rs.close();
//            conn3.close();
//        } catch (SQLException e) {
//            System.out.println("Error al obtener del Detalle !");
//        }
//        return lstDetalleFactura;
//    }

}
