package co.edu.uniquindio.ingesis.restful.dtos.programs;

import java.time.LocalDate;

public record ProgramUpdateRequest(
        String programId,
        String title,
        String description,
        String sourceCode,
        String type
) {
}
