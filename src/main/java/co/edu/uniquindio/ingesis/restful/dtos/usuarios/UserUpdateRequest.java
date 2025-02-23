package co.edu.uniquindio.ingesis.restful.dtos.usuarios;

import co.edu.uniquindio.ingesis.restful.domain.Rol;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserUpdateRequest(
        /* no se toman en cuenta variables no actualizables tales como
        la fecha de nacimiento o el rol
         */
        @NotBlank(message = "El id no puede ser nulo")
        String id,
        @NotBlank(message = "El campo es requerido")
        @Email(message = "Debe ser un email válido")
        String email,
        @NotBlank(message = "El campo es requerido")
        @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).*$",message = "Debe contener a")
        @Size(min = 8,message = "La longitud mínima es 8")
        String password,
        @NotBlank(message = "El campo es requerido")
        @Size(max = 100,message = "No debe exceder los 100 caracteres")
        String fullName
) {
}
