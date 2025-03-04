package co.edu.uniquindio.ingesis.restful.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User extends PanacheEntity {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$",
            message = "La contraseña debe tener al menos una mayúscula, una minúscula y un número.")
    private String password;
    private String role;
    @NotBlank
    private String identificationNumber;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private Rol rol;
    @NotNull
    private Long idGroup;
}
