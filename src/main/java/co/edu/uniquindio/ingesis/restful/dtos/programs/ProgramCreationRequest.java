package co.edu.uniquindio.ingesis.restful.dtos.programs;

import java.time.LocalDate;

public record ProgramCreationRequest(
        String title,
        String description,
        String sourceCode,
        LocalDate creationDate,
        LocalDate modificationDate,
        String type,
        String userId
) {
}
