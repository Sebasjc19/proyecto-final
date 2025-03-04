package co.edu.uniquindio.ingesis.restful.dtos.programs;

import co.edu.uniquindio.ingesis.restful.domain.TYPE;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

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
