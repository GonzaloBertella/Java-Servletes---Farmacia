/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Cliente {

    private int cod_cli;
    private String nom_cli;
    private String dir_cli;
    private Barrio barrio;
    private int DNI;
    private String telefono;

    public Cliente(int cod_cli, String nom_cli, String dir_cli, Barrio barrio, int DNI, String telefono) {
        this.cod_cli = cod_cli;
        this.nom_cli = nom_cli;
        this.dir_cli = dir_cli;
        this.barrio = barrio;
        this.DNI = DNI;
        this.telefono = telefono;
    }

    public Cliente(String nom_cli, String dir_cli, Barrio barrio, int DNI, String telefono) {
        this.nom_cli = nom_cli;
        this.dir_cli = dir_cli;
        this.barrio = barrio;
        this.DNI = DNI;
        this.telefono = telefono;
    }

    public Cliente() {
    }

    public int getCod_cli() {
        return cod_cli;
    }

    public void setCod_cli(int cod_cli) {
        this.cod_cli = cod_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public String getDir_cli() {
        return dir_cli;
    }

    public void setDir_cli(String dir_cli) {
        this.dir_cli = dir_cli;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Clientes{" + "cod_cli=" + cod_cli + ", nom_cli=" + nom_cli + ", dir_cli=" + dir_cli + ", barrio=" + barrio + ", DNI=" + DNI + ", telefono=" + telefono + '}';
    }

}
