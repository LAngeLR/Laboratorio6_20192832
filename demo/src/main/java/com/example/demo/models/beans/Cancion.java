package com.example.demo.models.beans;

public class Cancion{

    private String nombre;
    private int idCancion;
    private String banda;

    public Cancion(String nombre, int idCancion, String banda) {
        this.nombre = nombre;
        this.idCancion = idCancion;
        this.banda = banda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
}
