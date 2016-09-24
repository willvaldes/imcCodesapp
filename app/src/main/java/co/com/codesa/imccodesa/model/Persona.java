package co.com.codesa.imccodesa.model;

/**
 * Created by CODESA on 24/09/2016.
 */

public class Persona {
    private String nombre;
    private Double altura;
    private Double peso;
    private Double imc;

    public Persona(String nombre, Double altura, Double peso, Double imc) {
        this.nombre = nombre;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }
}
