package co.edu.uniquindio.ingesis.restful.dtos.usuarios;

import jakarta.validation.constraints.NotBlank;

public record ErrorResponse(@NotBlank String tipo, @NotBlank String descripcion) {
}