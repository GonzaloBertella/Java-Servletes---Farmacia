/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Localidad {
    
    private int cod_localidad;
    private String nombre_localidad;
    private Provincia provincia;

    public Localidad(int cod_localidad, String nombre_localidad, Provincia provincia) {
        this.cod_localidad = cod_localidad;
        this.nombre_localidad = nombre_localidad;
        this.provincia = provincia;
    }

    public Localidad() {
    }

    public int getCod_localidad() {
        return cod_localidad;
    }

    public void setCod_localidad(int cod_localidad) {
        this.cod_localidad = cod_localidad;
    }

    public String getNombre_localidad() {
        return nombre_localidad;
    }

    public void setNombre_localidad(String nombre_localidad) {
        this.nombre_localidad = nombre_localidad;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Localidad{" + "cod_localidad=" + cod_localidad + ", nombre_localidad=" + nombre_localidad + ", provincia=" + provincia + '}';
    }
    
    
    
}
