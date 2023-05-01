package com.example;

public class UsuarioEsquema{

    private String nombre;
    private String contraseña;
    private String email;
    private String meta;
    private int montoObjetivo;
    private int dineroActual;


    public String getNombre(){
        return nombre;
    }
    public String getContraseña(){
        return contraseña;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public int getMontoObjetivo(){
        return montoObjetivo;
    }

    public void setMontoObjetivo(int montoObjetivo){
        this.montoObjetivo = montoObjetivo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public int getDineroActual(){
        return dineroActual;
    }

    public void setDineroActual(int dineroActual){
        this.dineroActual = dineroActual;
    }

    public String getMeta(){
        return meta;
    }

    public void setMeta(String meta){
        this.meta = meta;
    }

}