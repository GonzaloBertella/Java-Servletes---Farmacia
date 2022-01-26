/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Proveedor {

    private int cod_prov;
    private String nom_prov;
    private String dir_prov;
    private Barrio barrio;
    private String telefono;

    public Proveedor(int cod_prov, String nom_prov, String dir_prov, Barrio barrio, String telefono) {
        this.cod_prov = cod_prov;
        this.nom_prov = nom_prov;
        this.dir_prov = dir_prov;
        this.barrio = barrio;
        this.telefono = telefono;
    }

    public Proveedor(String nom_prov, String dir_prov, Barrio barrio, String telefono) {
        this.nom_prov = nom_prov;
        this.dir_prov = dir_prov;
        this.barrio = barrio;
        this.telefono = telefono;
    }

    public Proveedor() {
    }

    public int getCod_prov() {
        return cod_prov;
    }

    public void setCod_prov(int cod_prov) {
        this.cod_prov = cod_prov;
    }

    public String getNom_prov() {
        return nom_prov;
    }

    public void setNom_prov(String nom_prov) {
        this.nom_prov = nom_prov;
    }

    public String getDir_prov() {
        return dir_prov;
    }

    public void setDir_prov(String dir_prov) {
        this.dir_prov = dir_prov;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    
    
    
    
}
