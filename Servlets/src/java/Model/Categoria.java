/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Categoria {
    
    private int cod_categoria;
    private String descripcion;

    public Categoria(int cod_categoria, String descripcion) {
        this.cod_categoria = cod_categoria;
        this.descripcion = descripcion;
    }

    public Categoria() {
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categoria{" + "cod_categoria=" + cod_categoria + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
