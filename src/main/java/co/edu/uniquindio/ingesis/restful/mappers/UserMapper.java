package co.edu.uniquindio.ingesis.restful.mappers;

import co.edu.uniquindio.ingesis.restful.domain.User;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;
import io.quarkus.elytron.security.common.BcryptUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.JAKARTA_CDI)
public interface UserMapper {
    @Mapping(target = "id", ignore = true) // El ID se generará automáticamente
    @Mapping(target = "password", expression = "java(hashPassword(userRequest.password()))")
    User toEntity(UserRegistrationRequest userRequest);
    UserResponse toUserResponse(User user);
    default String hashPassword(String password) {
        return BcryptUtil.bcryptHash(password); // Se usa Bcrypt para encriptar la contraseña
    }
}
