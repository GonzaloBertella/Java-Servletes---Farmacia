/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Barrio {
    
    private int cod_barrio;
    private String barrio;
    private Localidad localidad;

    public int getCod_barrio() {
        return cod_barrio;
    }

    public void setCod_barrio(int cod_barrio) {
        this.cod_barrio = cod_barrio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Barrio(int cod_barrio, String barrio, Localidad localidad) {
        this.cod_barrio = cod_barrio;
        this.barrio = barrio;
        this.localidad = localidad;
    }

    public Barrio() {
    }

    @Override
    public String toString() {
        return "Barrio{" + "cod_barrio=" + cod_barrio + ", barrio=" + barrio + ", localidad=" + localidad + '}';
    }
    
    
}
