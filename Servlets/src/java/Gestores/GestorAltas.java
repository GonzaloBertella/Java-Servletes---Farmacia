/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestores;

import Model.DetalleFactura;
import Model.Empleado;
import Model.Factura;
import Model.Producto;
import Model.Proveedor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class GestorAltas {

    private final String url = "jdbc:sqlserver://localhost;databaseName=FarmaciaLab4";
    private final String user = "sa";
    private final String pass = "Gmb+1992";

    public GestorAltas() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorAltas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int registrarFactura(Factura v, ArrayList<DetalleFactura> lst) {
        //Carga Factura
        int cod_venta = 0;
        ResultSet rs = null;
        Connection cnn1 = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;

        try {

            cnn1 = DriverManager.getConnection(url, user, pass);
            cnn1.setAutoCommit(false);
            ps = cnn1.prepareStatement("Insert into Facturas values(?, ? , ? , ?)");

            ps.setDate(1, v.getFecha());
            ps.setInt(2, v.getCliente().getCod_cli());
            ps.setInt(3, v.getEmpleado().getCod_emp());
            ps.setInt(4, v.getSucursal().getCod_sucursal());

            ps.executeUpdate();

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas != 0) {
                Statement st = cnn1.createStatement();
                rs = st.executeQuery("select @@identity cod_venta");
                if (rs.next()) {
                    cod_venta = rs.getInt("cod_venta");
                    rs.close();
                }
                for (DetalleFactura df : lst) {
                    ps2 = cnn1.prepareStatement("Insert into DetalleFacturas values( ?, ? , ? , ? , ? , ? )");

                    v.setCod_venta(cod_venta);
                    df.setFactura(v);
                    ps2.setInt(1, df.getFactura().getCod_venta());
                    ps2.setInt(2, df.getProducto().getCod_pro());
                    ps2.setInt(3, df.getCantidad());
                    ps2.setFloat(4, df.getPrecio_unitario());
                    int tipoPago = df.getTipoPago().getCod_tipoPago();
                    ps2.setInt(5, tipoPago);
                    float importeTotal = df.getImporteTotal();
                    ps2.setFloat(6, importeTotal);

                    ps2.executeUpdate();
                }
                cnn1.commit();
                ps2.close();

            }
            ps.close();
        } catch (SQLException | NumberFormatException e) {
            try {
                cnn1.rollback();
            } catch (SQLException ex1) {
                System.out.println("Error de acceso a datos ");
            }
            System.out.println("Error de acceso a datos ");
        }
        return cod_venta;
    }

    public void registrarProducto(Producto p) {
        //Cargar Producto
        try (Connection cnn1 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn1.prepareStatement("Insert into Productos values(?, ? , ?, ? , ? , ? , ? , ? , ?)")) {

            ps.setString(1, p.getDescripcion());
            ps.setInt(2, p.getPre_compra());
            ps.setDate(3, p.getFecha_venc());
            ps.setInt(4, p.getMarca().getCod_marca());
            ps.setInt(5, p.getProveedor().getCod_prov());
            ps.setInt(6, p.getCategoria().getCod_categoria());
            ps.setBoolean(7, p.isVenta_libre());
            ps.setInt(8, p.getStock());
            ps.setInt(9, p.getSucursal().getCod_sucursal());

            ps.executeUpdate();

        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error de acceso a datos ");
        }

    }

    public void registrarProveedor(Proveedor pr) {
        //Cargar Producto
        try (Connection cnn1 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn1.prepareStatement("Insert into Proveedores values(?, ? , ?, ? )")) {

            ps.setString(1, pr.getNom_prov());
            ps.setString(2, pr.getDir_prov());
            ps.setInt(3, pr.getBarrio().getCod_barrio());
            ps.setString(4, pr.getTelefono());

            ps.executeUpdate();

        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error de acceso a datos del Proveedor ");
        }

    }

    public void registrarDetalle(DetalleFactura df) {
        //Carga Detalle
        try (Connection cnn2 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn2.prepareStatement("Insert into DetelleFacturas values(?, ? , ? , ? , ? , ?)")) {

            ps.setInt(1, df.getFactura().getCod_venta());
            ps.setInt(2, df.getProducto().getCod_pro());
            int cantidad = df.getCantidad();
            ps.setInt(3, df.getCantidad());
            float importe = df.getPrecio_unitario();
            ps.setFloat(4, df.getPrecio_unitario());
            int tipoPago = df.getTipoPago().getCod_tipoPago();
            ps.setInt(5, tipoPago);
            float importeTotal = df.getImporteTotal();
            if (tipoPago == 1) {
                importeTotal = (importe * cantidad) * (float) 1.25;
            } else {
                importeTotal = (importe * cantidad) - ((importe * cantidad) * (float) 0.10);
            }
            ps.setFloat(6, importeTotal);

            ps.executeUpdate();

        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error de acceso a datos ");
        }

    }

    public void registrarEmpleado(Empleado em) {
        //Cargar Producto
        try (Connection cnn1 = DriverManager.getConnection(url, user, pass);
                PreparedStatement ps = cnn1.prepareStatement("Insert into Empleados values(?, ? , ?, ? , ? , ? )")) {

            ps.setString(1, em.getNom_emp());
            ps.setString(2, em.getDir_emp());
            ps.setInt(3, em.getBarrio().getCod_barrio());
            ps.setString(4, em.getCargo());
            ps.setString(5, em.getEdad());
            ps.setString(6, em.getTel());

            ps.executeUpdate();

        } catch (SQLException | NumberFormatException e) {
            System.out.println("Error de acceso a datos del Empleado ");
        }

    }

}
