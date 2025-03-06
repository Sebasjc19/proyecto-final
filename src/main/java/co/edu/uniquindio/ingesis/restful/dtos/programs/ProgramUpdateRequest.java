package co.edu.uniquindio.ingesis.restful.dtos.programs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProgramUpdateRequest(
        @NotNull
        Long programId,
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
