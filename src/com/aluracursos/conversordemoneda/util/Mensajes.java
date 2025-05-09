package com.aluracursos.conversordemoneda.util;

import com.aluracursos.conversordemoneda.logica.ConversorInteractivo;
import com.aluracursos.conversordemoneda.modelo.DatosApi;
import com.aluracursos.conversordemoneda.modelo.DatosUsuario;

public class Mensajes {

    public static void mostraPresentacion() {
        System.out.println("***********************************");
        System.out.println("Bienvenido al conversor de moneda");
        System.out.println("***********************************");
    }

    public static void mostrarMenu() {
        System.out.println("""
                    
                     1.  Dólar ----->>> Peso chileno
                     2.  Peso chileno ----->>> Dólar
                     3.  Dólar ----->>> Peso argentino
                     4.  Peso argentino ----->>> Dólar
                     5.  Dólar ----->>> Peso colombiano
                     6.  Peso colombiano ----->>> Dólar
                     7.  Dólar ----->>> Real brasileño
                     8.  Real brasileño ----->>> Dólar
                     9.  Mostrar el historial de conversiones
                     10. Salir
                
                    """);

    }

    public static void mostrarResultado(DatosUsuario usuario, DatosApi datosApi) {

        System.out.println(String.format("""
                        
                        ======================================================================
                                            Resultado de la conversión
                        ======================================================================
                        Valor Ingresado                : %.2f %s
                        Tipo de cambio                 : %s " a " %s
                        Valor convertido               : %.2f %s
                        ======================================================================
                        """, usuario.valorAconvertir(), usuario.base_code(), usuario.base_code(), usuario.target_code(), datosApi.conversion_result(), usuario.target_code()));
    }

    public static String mostrarHistorial(DatosUsuario usuario, DatosApi datosApi) {
       return String.format("""
                        
                        ======================================================================
                                            Historial de conversiones
                        ======================================================================
                        Valor Ingresado                : %.2f %s
                        Tipo de cambio                 : %s " a " %s
                        Valor convertido               : %.2f %s
                        ======================================================================
                        """, usuario.valorAconvertir(), usuario.base_code(), usuario.base_code(), usuario.target_code(), datosApi.conversion_result(), usuario.target_code());
    }

}
