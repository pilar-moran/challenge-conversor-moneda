package com.aluracursos.conversordemoneda.util;

public class Mensajes {

    public static void presentacion () {
        System.out.println("***********************************");
        System.out.println("Bienvenido al conversor de moneda");
        System.out.println("***********************************");
    }

    public static void menu() {
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

}
