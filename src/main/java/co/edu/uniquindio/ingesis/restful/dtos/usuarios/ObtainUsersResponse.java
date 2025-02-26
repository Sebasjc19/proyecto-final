package co.edu.uniquindio.ingesis.restful.dtos.usuarios;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public record ObtainUsersResponse(
        @NotBlank(message = "El usuario no registra un nombre")
        String nombre,
        @NotBlank(message = "El usuario no registra un apellido")
        String apellido,
        @NotBlank(message = "El usuario no registra un nombre de usuario")
        String username,
        @NotBlank(message = "El usuario no registra una fecha de nacimiento")
        @PastOrPresent(message = "La fecha no puede ser futura")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate dateBirth,
        @NotBlank(message = "El usuario no registra un telefono")
        String telefono
) {
}
