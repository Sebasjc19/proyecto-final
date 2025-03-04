package co.edu.uniquindio.ingesis.restful.services.implementations;

import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;
import co.edu.uniquindio.ingesis.restful.services.interfaces.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final UserMapper userMapper;

    @Transactional
    public UserResponse createUser(UserRegistrationRequest request) {
        // Lógica para crear un usuario
        User user = userMapper.parseOf(request);
        user.persist();

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse findById(Long id) {
        User user = User.findById(id);
        if( user == null ){
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
        return userMapper.toUserResponse(user);
    }
}
