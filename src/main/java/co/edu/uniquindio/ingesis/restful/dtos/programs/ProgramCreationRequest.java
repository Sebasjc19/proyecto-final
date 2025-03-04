package co.edu.uniquindio.ingesis.restful.dtos.programs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProgramCreationRequest(
        @NotNull
        @NotBlank
        String title,
        @NotBlank
        String description,
        @NotBlank
        String code,
        @NotNull
        Long userId
) {
}
