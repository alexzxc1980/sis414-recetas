package com.example.sis414recetas.Models;

public class RecetaModel {
    private String nombrePlato;
    private String categoriaCulinaria;
    private TiempoModel tiempo;

    public RecetaModel() {}

    public RecetaModel(String nombrePlato, String categoriaCulinaria, TiempoModel tiempo) {
        this.nombrePlato = nombrePlato;
        this.categoriaCulinaria = categoriaCulinaria;
        this.tiempo = tiempo;
    }

    public String getNombrePlato() { return nombrePlato; }
    public void setNombrePlato(String nombrePlato) { this.nombrePlato = nombrePlato; }

    public String getCategoriaCulinaria() { return categoriaCulinaria; }
    public void setCategoriaCulinaria(String categoriaCulinaria) { this.categoriaCulinaria = categoriaCulinaria; }

    public TiempoModel getTiempo() { return tiempo; }
    public void setTiempo(TiempoModel tiempo) { this.tiempo = tiempo; }
}