/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author gonza
 */
public class Empleado {

    private int cod_emp;
    private String nom_emp;
    private String dir_emp;
    private Barrio barrio;
    private String cargo;
    private String edad;
    private String tel;

    public Empleado(int cod_emp, String nom_emp, String dir_emp, Barrio barrio, String cargo, String edad, String tel) {
        this.cod_emp = cod_emp;
        this.nom_emp = nom_emp;
        this.dir_emp = dir_emp;
        this.barrio = barrio;
        this.cargo = cargo;
        this.edad = edad;
        this.tel = tel;
    }

    public Empleado(String nom_emp, String dir_emp, Barrio barrio, String cargo, String edad, String tel) {
        this.nom_emp = nom_emp;
        this.dir_emp = dir_emp;
        this.barrio = barrio;
        this.cargo = cargo;
        this.edad = edad;
        this.tel = tel;
    }

    public Empleado() {
    }

    public int getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(int cod_emp) {
        this.cod_emp = cod_emp;
    }

    public String getNom_emp() {
        return nom_emp;
    }

    public void setNom_emp(String nom_emp) {
        this.nom_emp = nom_emp;
    }

    public String getDir_emp() {
        return dir_emp;
    }

    public void setDir_emp(String dir_emp) {
        this.dir_emp = dir_emp;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cod_emp=" + cod_emp + ", nom_emp=" + nom_emp + ", dir_emp=" + dir_emp + ", barrio=" + barrio + ", cargo=" + cargo + ", edad=" + edad + ", tel=" + tel + '}';
    }

}
