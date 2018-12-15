package com.example.gamer.patronmaestrodetalle.entidades;

import java.io.Serializable;

public class Personajes implements Serializable{//para que peuda transportar el objeto de un fragment a otro

    private String nombre;
    private String info;
    private int foto;

    private int imagendetalle;
    private String descridetalle;


    public Personajes() {
    }

   /* public Personajes(String nombre, String info, int foto) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
    }*/

    public Personajes(String nombre, String info, int foto, int imagendetalle, String descridetalle) {
        this.nombre = nombre;
        this.info = info;
        this.foto = foto;
        this.imagendetalle = imagendetalle;
        this.descridetalle = descridetalle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getImagendetalle() {
        return imagendetalle;
    }

    public void setImagendetalle(int imagendetalle) {
        this.imagendetalle = imagendetalle;
    }

    public String getDescridetalle() {
        return descridetalle;
    }

    public void setDescridetalle(String descridetalle) {
        this.descridetalle = descridetalle;
    }
}
