package co.edu.uniquindio.ingesis.restful.repositories.implementations;

import co.edu.uniquindio.ingesis.restful.domain.User;
import co.edu.uniquindio.ingesis.restful.repositories.interfaces.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> userOptional = find("email", email).firstResultOptional();
        return Optional.empty();
    }
}
