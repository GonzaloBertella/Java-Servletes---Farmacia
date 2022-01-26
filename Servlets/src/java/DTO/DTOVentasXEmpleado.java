/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author gonza
 */
public class DTOVentasXEmpleado {
    
    private int cod_emp;
    private String nom_emp;
    private int cod_venta;

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public int getCod_venta() {
        return cod_venta;
    }

    public void setCod_venta(int cod_venta) {
        this.cod_venta = cod_venta;
    }

    @Override
    public String toString() {
        return "DTOVentasXEmpleado{" + "cod_emp=" + cod_emp + ", nom_emp=" + nom_emp + ", cod_venta=" + cod_venta + '}';
    }
    
    
    
}
