package com.aluracursos.conversordemoneda.modelo;

public record DatosApi(String base_code,
                       String target_code,
                       double conversion_rate,
                       double conversion_result) {
}
