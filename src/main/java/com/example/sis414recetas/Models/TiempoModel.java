package com.example.sis414recetas.Models;

public class TiempoModel {
    private String duracionTotal;
    private String nivelDificultad;

    public TiempoModel() {}

    public TiempoModel(String duracionTotal, String nivelDificultad) {
        this.duracionTotal = duracionTotal;
        this.nivelDificultad = nivelDificultad;
    }

    public String getDuracionTotal() { return duracionTotal; }
    public void setDuracionTotal(String duracionTotal) { this.duracionTotal = duracionTotal; }

    public String getNivelDificultad() { return nivelDificultad; }
    public void setNivelDificultad(String nivelDificultad) { this.nivelDificultad = nivelDificultad; }
}