package com.example;

public class Consumo {

    private String nombre;
    public Consumo(String nombre){
        this.nombre = nombre;
    }

    public int agregarGasto(int gasto)throws Exception{
        UsuarioEsquema usuario = Archivo.getUser(this.nombre);
        if(gasto <= 0){
            throw new Exception("Debes introducir un gasto mayor a 0");
        }

        verificarGasto(gasto, usuario.getDineroActual());
        int dineroActual = usuario.getDineroActual() - gasto;
        usuario.setDineroActual(dineroActual);
        Archivo.postUser(usuario);
        return dineroActual;
    }

    public int agregarIngreso(int ingreso)throws Exception{
        UsuarioEsquema usuario = Archivo.getUser(this.nombre);
        if(ingreso <= 0){
            throw new Exception("Debes introducir un ingreso mayor a 0");
        }

        int dineroActual = usuario.getDineroActual() + ingreso;

        verificarCompletarMeta(dineroActual, dineroActual, usuario);
        usuario.setDineroActual(dineroActual);
        Archivo.postUser(usuario);
        return dineroActual;
    }

    public boolean verificarGasto(int gasto, int dineroActual){
        if(gasto > dineroActual){
            throw new ArithmeticException("El gasto no puede exeder la cantidad de dinero actual");
        }
        return true;
    }

    public boolean verificarCompletarMeta(int dineroActual, int montoObjetivo, UsuarioEsquema usuario){
        if(dineroActual >= usuario.getMontoObjetivo()){
            System.out.println("Felicidades joven " + usuario.getNombre() + " has completado la meta: " + usuario.getMeta());
            return true;
        }

        return false;
    }

}
