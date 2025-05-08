package com.aluracursos.conversordemoneda.logica;

import com.aluracursos.conversordemoneda.modelo.DatosUsuario;
import com.aluracursos.conversordemoneda.modelo.DatosApi;
import com.aluracursos.conversordemoneda.servicio.ConversorMonedaApi;
import com.aluracursos.conversordemoneda.util.Mensajes;

import java.util.Scanner;


public class ConversorInteractivo {

    public DatosUsuario iniciarInteraccion() {

        String base_code = "";
        String target_code = "";
        double valorAconvertir = 0;

        Scanner teclado = new Scanner(System.in);

        Mensajes.presentacion();

        while (true) {
            Mensajes.menu();
            System.out.println("Seleccione una opción:");
            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1 -> {base_code = "USD"; target_code = "CLP";}
                case 2 -> {base_code = "CLP"; target_code = "USD";}
                case 3 -> {base_code = "USD"; target_code = "ARS";}
                case 4 -> {base_code = "ARS"; target_code = "USD";}
                case 5 -> {base_code = "USD"; target_code = "COP";}
                case 6 -> {base_code = "COP"; target_code = "USD";}
                case 7 -> {base_code = "USD"; target_code = "BRL";}
                case 8 -> {base_code = "BRL"; target_code = "USD";}
                case 9 -> {
                    HistorialDeConversiones historial = new HistorialDeConversiones();
                    historial.mostrarHistorial();
                }
                case 10 -> {
                    System.out.println("Ha sido un gusto atenderlo.");
                    HistorialDeConversiones historial = new HistorialDeConversiones();
                    historial.limpiarHistorial();
                    return null;
                }
                default -> {
                    System.out.println("Opción inválida. Intente nuevamente.");
                    continue;
                }
            }

            if (opcion != 9) {
                System.out.println(String.format("Ingrese la cantidad a convertir (%s -> %s):", base_code, target_code));
                valorAconvertir = teclado.nextDouble();
                teclado.nextLine();

                DatosUsuario datosUsuario = new DatosUsuario(base_code, target_code, valorAconvertir);
                DatosApi datosApi = new ConversorMonedaApi().consultarApiDeCambio(datosUsuario);

                HistorialDeConversiones historial = new HistorialDeConversiones();
                String historialTexto = String.format("""
            ======================================================================
                                   Historial de conversiones
            ======================================================================
            Valor Ingresado                : %.2f %s
            Tipo de cambio                 : %s " a " %s
            Valor convertido               : %.2f %s
            ======================================================================
            """, valorAconvertir,base_code, base_code, target_code, datosApi.conversion_result(), target_code
                );
                historial.agregarConversion(historialTexto);

                if (datosApi != null) {
                    System.out.println(String.format("""
                        
                        ======================================================================
                                            Resultado de la conversión
                        ======================================================================
                        Valor Ingresado                : %.2f %s
                        Tipo de cambio                 : %s " a " %s
                        Valor convertido               : %.2f %s
                        ======================================================================
                        """, valorAconvertir,base_code, base_code, target_code, datosApi.conversion_result(), target_code
                    ));
                } else {
                    System.out.println("No se pudo realizar la conversión. Intente nuevamente.");
                }

                System.out.println("¿Desea realizar otra conversión? (si = 0 / no = 1)");
                int respuesta = teclado.nextInt();
                teclado.nextLine();

                if (respuesta == 0) {
                    continue;
                } else if (respuesta == 1) {
                    System.out.println("Gracias por usar el conversor de moneda.");
                    historial.limpiarHistorial();
                    return null;
                } else {
                    System.out.println("Opción inválida. Saliendo del programa.");
                    return null;
                }
            }
        }



    }
}