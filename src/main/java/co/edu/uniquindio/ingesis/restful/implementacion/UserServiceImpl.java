package co.edu.uniquindio.ingesis.restful.implementacion;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;
import co.edu.uniquindio.ingesis.restful.mappers.UserMapper;
import co.edu.uniquindio.ingesis.restful.services.UserService;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import co.edu.uniquindio.ingesis.restful.domain.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Inject
    UserMapper userMapper;

    @Override
    public UserResponse getUsuarioById(Long id) {
        User user = User.findById(id);
        if (user == null) {
            throw new NotFoundException("Usuario no encontrado con ID: " + id);
        }
        return userMapper.toUserResponse(user);
    }

    @Override
    @Transactional
    public UserResponse deleteUsuario(Long id) {
        User user = User.findById(id);
        if (user == null) {
            throw new NotFoundException("Usuario no encontrado con ID: " + id);
        }
        user.delete();
        return userMapper.toUserResponse(user);
    }
}

