package com.example;

public class Registrar{


    public void registro(String nombre, String email, String contraseña)throws Exception{
        UsuarioEsquema usuarioNUevo = new UsuarioEsquema();

        if(nombre.equals("")){
            throw new Exception("Nombre No Valido");
        }

        if(email.equals("")){
            throw new Exception("Email No Valido");
        }

        if(contraseña.equals("")){
            throw new Exception("Contraseña No Valido");
        }

        usuarioNUevo.setNombre(nombre);
        usuarioNUevo.setEmail(email);
        usuarioNUevo.setContraseña(contraseña);
        Archivo.postUser(usuarioNUevo);
    }
}
