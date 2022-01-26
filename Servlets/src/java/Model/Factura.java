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
public class Factura {

    private int cod_venta;
    private Empleado empleado;
    private Cliente cliente;
    private Date fecha;
    private Sucursal sucursal;

    public Factura(int cod_venta, Empleado empleado, Cliente cliente, Date fecha, Sucursal sucursal) {
        this.cod_venta = cod_venta;
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
        this.sucursal = sucursal;
    }

    public Factura(Empleado empleado, Cliente cliente, Date fecha, Sucursal sucursal) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.fecha = fecha;
        this.sucursal = sucursal;
    }

    public Factura() {
    }

    public int getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Factura{" + "cod_venta=" + cod_venta + ", empleado=" + empleado + ", cliente=" + cliente + ", fecha=" + fecha + ", sucursal=" + sucursal + '}';
    }


    
}
