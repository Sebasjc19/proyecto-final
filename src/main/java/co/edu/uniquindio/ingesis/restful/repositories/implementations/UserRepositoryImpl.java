package co.edu.uniquindio.ingesis.restful.repositories.implementations;

import co.edu.uniquindio.ingesis.restful.domain.User;
import co.edu.uniquindio.ingesis.restful.repositories.interfaces.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> finByEmail(String email) {
        Optional<User> userOptional = find("email", email).firstResultOptional();
        return Optional.empty();
    }
}
