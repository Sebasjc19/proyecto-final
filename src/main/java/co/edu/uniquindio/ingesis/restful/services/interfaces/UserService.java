package co.edu.uniquindio.ingesis.restful.services.interfaces;

import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;

public interface UserService {
    UserResponse createUser(UserRegistrationRequest request);
    UserResponse findById(Long id);
    UserResponse getUsuarioById(Long id);
    UserResponse  deleteUsuario(Long id);
}
