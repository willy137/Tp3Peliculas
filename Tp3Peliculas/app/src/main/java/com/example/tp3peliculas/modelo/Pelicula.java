package com.example.tp3peliculas.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {

    private String titulo, descripcion, director, actores;

    private int portada;

    public Pelicula(){

    }

    public Pelicula(String titulo, String descripcion, int portada, String director, String actores) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.portada = portada;
        this.director = director;
        this.actores = actores;
    }

    public Pelicula(String titulo, String descripcion, String director, String actores) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.director = director;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }
}
