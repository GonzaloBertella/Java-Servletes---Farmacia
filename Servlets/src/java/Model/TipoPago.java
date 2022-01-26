/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class TipoPago {

    private int cod_tipoPago;
    private String nom_form_pago;

    public TipoPago(int cod_tipoPago, String nom_form_pago) {
        this.cod_tipoPago = cod_tipoPago;
        this.nom_form_pago = nom_form_pago;
    }

    public TipoPago() {
    }

    public int getCod_tipoPago() {
        return cod_tipoPago;
    }

    public void setCod_tipoPago(int cod_tipoPago) {
        this.cod_tipoPago = cod_tipoPago;
    }

    public String getNom_form_pago() {
        return nom_form_pago;
    }

    public void setNom_form_pago(String nom_form_pago) {
        this.nom_form_pago = nom_form_pago;
    }

    @Override
    public String toString() {
        return "TipoPago{" + "cod_tipoPago=" + cod_tipoPago + ", nom_form_pago=" + nom_form_pago + '}';
    }

}
