/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author gonza
 */
public class DTORankingFacturacion {
    
    private String descripcion;
    private Float importeTotal;

    public DTORankingFacturacion(String descripcion, Float importeTotal) {
        this.descripcion = descripcion;
        this.importeTotal = importeTotal;
    }

    public DTORankingFacturacion() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Float importeTotal) {
        this.importeTotal = importeTotal;
    }

    @Override
    public String toString() {
        return "DTORankingFacturacion{" + "descripcion=" + descripcion + ", importeTotal=" + importeTotal + '}';
    }
    
    
    
    
}
