/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Provincia {
    
    private int cod_provincia;
    private String nombre_provincia;

    public Provincia(int cod_provincia, String nombre_provincia) {
        this.cod_provincia = cod_provincia;
        this.nombre_provincia = nombre_provincia;
    }

    public Provincia() {
    }

    public int getCod_provincia() {
        return cod_provincia;
    }

    public void setCod_provincia(int cod_provincia) {
        this.cod_provincia = cod_provincia;
    }

    public String getNombre_provincia() {
        return nombre_provincia;
    }

    public void setNombre_provincia(String nombre_provincia) {
        this.nombre_provincia = nombre_provincia;
    }

    @Override
    public String toString() {
        return "Provincia{" + "cod_provincia=" + cod_provincia + ", nombre_provincia=" + nombre_provincia + '}';
    }
    
   
    
}
