/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class DetalleFactura {

    private int cod_detalleVenta;
    private Factura factura;
    private Producto producto;
    private int cantidad;
    private float precio_unitario;
    private TipoPago tipoPago;
    private float importeTotal;

    public DetalleFactura(int cod_detalleVenta, Factura factura, Producto producto, int cantidad, float precio_unitario, TipoPago tipoPago, float importeTotal) {
        this.cod_detalleVenta = cod_detalleVenta;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.tipoPago = tipoPago;
        this.importeTotal = importeTotal;
    }

    public DetalleFactura(Factura factura, Producto producto, int cantidad, float precio_unitario, TipoPago tipoPago, float importeTotal) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.tipoPago = tipoPago;
        this.importeTotal = importeTotal;
    }

    public DetalleFactura() {
    }

    public int getCod_detalleVenta() {
        return cod_detalleVenta;
    }

    public void setCod_detalleVenta(int cod_detalleVenta) {
        this.cod_detalleVenta = cod_detalleVenta;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "cod_detalleVenta=" + cod_detalleVenta + ", factura=" + factura + ", producto=" + producto + ", cantidad=" + cantidad + ", precio_unitario=" + precio_unitario + ", tipoPago=" + tipoPago + ", importeTotal=" + importeTotal + '}';
    }


}
