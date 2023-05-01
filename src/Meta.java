package com.example;

public class Meta {
    private String nombre;
    public Meta(String nombre){
        this.nombre = nombre;
    }
    public String crearMeta(String meta) throws Exception {
        if (meta.equals("")) {
            throw new Exception("Tiene que introducir una meta");
        }
        UsuarioEsquema usuario = Archivo.getUser(this.nombre);
        usuario.setMeta(meta);
        Archivo.postUser(usuario);
        return meta;
    }

    public int agregarMontoObjetivo(int monto) throws Exception {
        if (monto <= 0) {
            throw new Exception("Debe ingresar un monto mayor a cero");
        }
        UsuarioEsquema usuario = Archivo.getUser(this.nombre);
        usuario.setMontoObjetivo(monto);
        Archivo.postUser(usuario);
        return monto;
    }
}
