package co.edu.uniquindio.ingesis.restful.services.implementations;

import co.edu.uniquindio.ingesis.restful.domain.User;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserRegistrationRequest;
import co.edu.uniquindio.ingesis.restful.dtos.usuarios.UserResponse;
import co.edu.uniquindio.ingesis.restful.exceptions.usuarios.EmailAlredyExistsExceptionMapper;
import co.edu.uniquindio.ingesis.restful.exceptions.usuarios.ResourceNotFoundException;
import co.edu.uniquindio.ingesis.restful.mappers.UserMapper;
import co.edu.uniquindio.ingesis.restful.repositories.interfaces.UserRepository;
import co.edu.uniquindio.ingesis.restful.services.interfaces.UserService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Inject  UserMapper userMapper;
    final UserRepository userRepository;

    @Transactional
    public UserResponse createUser(UserRegistrationRequest request) {
        User user = userMapper.parseOf(request);
        Optional<User> optionalUser = userRepository.finByEmail(request.email());
        if(!optionalUser.isEmpty()){
            new EmailAlredyExistsExceptionMapper();
        }
        user.setRegistrationDate(LocalDate.now());
        user.persist();

        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse findById(Long id) {
        User user = User.findById(id);
        if( user == null ){
            new ResourceNotFoundException();
        }
        return userMapper.toUserResponse(user);
    }

    @Override
    public UserResponse getUsuarioById(Long id) {
        User user = User.findById(id);
        if (user == null) {
            new ResourceNotFoundException();
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
