package com.aluracursos.conversordemoneda.principal;

import com.aluracursos.conversordemoneda.logica.ConversorInteractivo;
import com.aluracursos.conversordemoneda.logica.HistorialDeConversiones;
import com.aluracursos.conversordemoneda.modelo.DatosUsuario;

public class Principal {

    public static void main(String[] args) {

        ConversorInteractivo interactivo = new ConversorInteractivo();
        DatosUsuario datosUsuario = interactivo.iniciarInteraccion();

    }
}