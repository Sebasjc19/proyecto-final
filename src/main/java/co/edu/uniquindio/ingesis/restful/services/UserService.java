package co.edu.uniquindio.ingesis.restful.services;

import co.edu.uniquindio.ingesis.restful.domain.User;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;
import co.edu.uniquindio.ingesis.restful.mappers.UserMapper;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

public interface UserService {

    UserResponse getUsuarioById(Long id);
    UserResponse  deleteUsuario(Long id);
}