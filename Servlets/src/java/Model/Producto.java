/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author gonza
 */
public class Producto {
    
    private int cod_pro;
    private String descripcion;
    private int pre_compra;
    private Date fecha_venc;
    private Marca marca;
    private Proveedor proveedor;
    private Categoria categoria;
    private boolean venta_libre;
    private int stock;
    private Sucursal sucursal;

    public Producto(int cod_pro, String descripcion, int pre_compra, Date fecha_venc, Marca marca, Proveedor proveedor, Categoria categoria, boolean venta_libre, int stock, Sucursal sucursal) {
        this.cod_pro = cod_pro;
        this.descripcion = descripcion;
        this.pre_compra = pre_compra;
        this.fecha_venc = fecha_venc;
        this.marca = marca;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.venta_libre = venta_libre;
        this.stock = stock;
        this.sucursal = sucursal;
    }

    public Producto(String descripcion, int pre_compra, Date fecha_venc, Marca marca, Proveedor proveedor, Categoria categoria, boolean venta_libre, int stock, Sucursal sucursal) {
        this.descripcion = descripcion;
        this.pre_compra = pre_compra;
        this.fecha_venc = fecha_venc;
        this.marca = marca;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.venta_libre = venta_libre;
        this.stock = stock;
        this.sucursal = sucursal;
    }

    public Producto() {
    }

    public int getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(int cod_pro) {
        this.cod_pro = cod_pro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPre_compra() {
        return pre_compra;
    }

    public void setPre_compra(int pre_compra) {
        this.pre_compra = pre_compra;
    }

    public Date getFecha_venc() {
        return fecha_venc;
    }

    public void setFecha_venc(Date fecha_venc) {
        this.fecha_venc = fecha_venc;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isVenta_libre() {
        return venta_libre;
    }

    public void setVenta_libre(boolean venta_libre) {
        this.venta_libre = venta_libre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Producto{" + "cod_pro=" + cod_pro + ", descripcion=" + descripcion + ", pre_compra=" + pre_compra + ", fecha_venc=" + fecha_venc + ", marca=" + marca + ", proveedor=" + proveedor + ", categoria=" + categoria + ", venta_libre=" + venta_libre + ", stock=" + stock + ", sucursal=" + sucursal + '}';
    }

    
    
}
