/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author gonza
 */
public class DTOFacturacion {
    
     private int cod_sucursal;
     private String nom_sucusal;
    private float importeTotal;

    public DTOFacturacion(int cod_sucursal, String nom_sucusal, float importeTotal) {
        this.cod_sucursal = cod_sucursal;
        this.nom_sucusal = nom_sucusal;
        this.importeTotal = importeTotal;
    }

    public DTOFacturacion() {
    }

    public int getCod_sucursal() {
        return cod_sucursal;
    }

    public void setCod_sucursal(int cod_sucursal) {
        this.cod_sucursal = cod_sucursal;
    }

    public String getNom_sucusal() {
        return nom_sucusal;
    }

    public void setNom_sucusal(String nom_sucusal) {
        this.nom_sucusal = nom_sucusal;
    }

    public float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }
 
}
