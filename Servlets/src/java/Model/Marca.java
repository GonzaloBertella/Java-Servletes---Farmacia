/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Marca {
    
    private int cod_marca;
    private String descripcion;

    public Marca(int cod_marca, String descripcion) {
        this.cod_marca = cod_marca;
        this.descripcion = descripcion;
    }

    public Marca() {
    }

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Marca{" + "cod_marca=" + cod_marca + ", descripcion=" + descripcion + '}';
    }
    
    
}
