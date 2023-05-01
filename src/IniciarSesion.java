package com.example;
import java.util.Scanner;
public class IniciarSesion {

    public void formulario(boolean iniciar)throws Exception {
        Scanner scanner = new Scanner(System.in);

        if(iniciar){
            System.out.println("Ingresa tu nombre");
            String nombre = scanner.nextLine();
            System.out.println("Ingresa tu contraseña");
            String contraseña = scanner.nextLine();
            UsuarioEsquema usuario = Archivo.getUser(nombre);
            if(contraseña.equals(usuario.getContraseña())){
                System.out.println("Bienvenido " + usuario.getNombre());
                accionesUsuario(usuario);
            }
        }
    }

    private void accionesUsuario(UsuarioEsquema usuario) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String salir;
        do{
            Consumo consumo = new Consumo(usuario.getNombre());
            System.out.println("1. Mostrar Progreso \n2. Crear meta \n3. Agregar gasto \n4. Agregar ingreso \n5. Cerrar Sesion");
            salir = scanner.nextLine();
            if(salir.equals("1")){
                UsuarioEsquema usuarioProgreso = Archivo.getUser(usuario.getNombre());
                if(usuario.getMeta().equals("null")){
                    System.out.println("No tienes ninguna meta creada");
                    accionesUsuario(usuario);
                }

                if(usuarioProgreso.getDineroActual() >= usuarioProgreso.getMontoObjetivo()){
                    System.out.println("Usted ya completó su meta actual, desea crear otra meta?\n1. Si\n2. No");
                    String respuesta = scanner.nextLine();
                    if(respuesta.equals("si")){
                        System.out.println("Ingrese la meta que quiere alcanzar");
                        String metaNueva = scanner.nextLine();
                        System.out.println("Ingrese el precio de la meta");
                        int montoNuevo = scanner.nextInt();
                        Meta meta = new Meta(usuario.getNombre());
                        meta.crearMeta(metaNueva);
                        meta.agregarMontoObjetivo(montoNuevo);
                        accionesUsuario(usuario);
                    }

                    if(respuesta.equals("no")){
                        mostrarProgreso(usuario.getNombre());
                    }
                }
                mostrarProgreso(usuario.getNombre());
            }

            if(salir.equals("2")){

                if(!usuario.getMeta().isEmpty()){
                    System.out.println("Ya tiene una meta");
                    accionesUsuario(usuario);
                }else{
                    System.out.println("Ingrese la meta que quiere alcanzar");
                    String metaNueva = scanner.nextLine();
                    System.out.println("Ingrese el precio de la meta");
                    int montoNuevo = scanner.nextInt();
                    Meta meta = new Meta(usuario.getNombre());
                    meta.crearMeta(metaNueva);
                    meta.agregarMontoObjetivo(montoNuevo);
                    accionesUsuario(usuario);
                }
            }

            if(salir.equals("3")){
                System.out.println("Ingrese el gasto");
                int gasto = scanner.nextInt();
                consumo.agregarGasto(gasto);
                accionesUsuario(usuario);
            }

            if(salir.equals("4")){
                System.out.println("Ingrese el ingreso");
                int ingreso = scanner.nextInt();
                if(usuario.getDineroActual() >= usuario.getMontoObjetivo()){
                    System.out.println("Usted ya completo su meta");
                    accionesUsuario(usuario);
                }else{
                    consumo.agregarIngreso(ingreso);
                    accionesUsuario(usuario);
                }
            }
        }while(!salir.equals("5"));
    }


    private void mostrarProgreso(String nombre){
        UsuarioEsquema usuario = Archivo.getUser(nombre);
        System.out.println("\n=============================================\n");
        System.out.println("Meta: " + usuario.getMeta() +
            "\nMonto del objetivo: " + usuario.getMontoObjetivo() +
            "\nDinero actual: " + usuario.getDineroActual()
        );
        System.out.println("\n=============================================\n");
    }

}
