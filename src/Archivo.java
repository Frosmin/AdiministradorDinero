package com.example;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Archivo {

    public static void postUser(UsuarioEsquema usuario) {
        try {
            BufferedWriter user = new BufferedWriter(new FileWriter(usuario.getNombre() + ".txt"));
            user.write("Nombre:" + usuario.getNombre() +
                       "\nContraseña:" + usuario.getContraseña() +
                       "\nEmail:" + usuario.getEmail() +
                       "\nMeta:" + usuario.getMeta() +
                       "\nMonto Objetivo:" + usuario.getMontoObjetivo() +
                       "\nDinero Actual:" + usuario.getDineroActual()
            );
            user.close();

        } catch (IOException e) {
            System.out.println("Error en los post...");
        }
    }

    public static UsuarioEsquema getUser(String name) {
        String response;
        UsuarioEsquema usuario = new UsuarioEsquema();
        try {
            Reader user = Files.newBufferedReader(Paths.get(name + ".txt"), StandardCharsets.ISO_8859_1);
            BufferedReader readUser = new BufferedReader(user);

            while((response = readUser.readLine()) != null){
                String [] dato = response.split(":");
                if(dato[0].equals("Nombre")){
                    usuario.setNombre(dato[1]);
                }
                if(dato[0].equals("Contraseña")){
                    usuario.setContraseña(dato[1]);
                }
                if(dato[0].equals("Email")){
                    usuario.setEmail(dato[1]);
                }
                if(dato[0].equals("Meta")){
                    usuario.setMeta(dato[1]);
                }
                if(dato[0].equals("Monto Objetivo")){
                    usuario.setMontoObjetivo(Integer.parseInt(dato[1]));
                }

                if(dato[0].equals("Dinero Actual")){
                    usuario.setDineroActual(Integer.parseInt(dato[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("El usuario no existe");
        }

        return usuario;
    }
}



