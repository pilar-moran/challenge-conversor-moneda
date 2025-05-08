package com.aluracursos.conversordemoneda.logica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialDeConversiones {

    private final List<String> historial = new ArrayList<>();
    private final File archivoHistorial = new File("historial.txt");

    public void agregarConversion(String conversion) {
        historial.add(conversion);
        guardarEnArchivo(conversion);
    }

    private void guardarEnArchivo(String conversion) {
        try (FileWriter writer = new FileWriter(archivoHistorial, true);
             BufferedWriter writerBuffered = new BufferedWriter(writer)) {
            writerBuffered.write(conversion);
            writerBuffered.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar la conversión en el archivo: " + e.getMessage());
        }
    }

    public void mostrarHistorial() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoHistorial))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de historial: " + e.getMessage());
        }
    }

    public void limpiarHistorial() {
        try (FileWriter writer = new FileWriter(archivoHistorial, false)) {

        } catch (IOException e) {
            System.out.println("Error al limpiar el historial: " + e.getMessage());
        }
    }



}
