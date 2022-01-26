/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Sucursal {
    
    private int cod_sucursal;
    private String nom_sucursal;
    private String direccion;
    private String telefono;
    private Barrio barrio;

    public Sucursal(int cod_sucursal, String nom_sucursal, String direccion, String telefono, Barrio barrio) {
        this.cod_sucursal = cod_sucursal;
        this.nom_sucursal = nom_sucursal;
        this.direccion = direccion;
        this.telefono= telefono;
        this.barrio = barrio;
    }

    public Sucursal(String nom_sucursal, String direccion , String telefono, Barrio barrio) {
        this.nom_sucursal = nom_sucursal;
        this.direccion = direccion;
         this.telefono= telefono;
        this.barrio = barrio;
    }

    public Sucursal() {
    }

    public int getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(int cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getNom_sucursal() {
        return nom_sucursal;
    }

    public void setNom_sucursal(String nom_sucursal) {
        this.nom_sucursal = nom_sucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
        public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "cod_sucursal=" + cod_sucursal + ", nom_sucursal=" + nom_sucursal + ", direccion=" + direccion + ", telefono"+ telefono + ", barrio=" + barrio + '}';
    }
    
    
    
}
