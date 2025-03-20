package dev.members.infrastructure.adapter;

import dev.members.domain.repository.UserCheckinRepositoryInterface;
import dev.members.domain.repository.UserRepositoryInterface;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.repository.UserCheckinRepository;
import dev.members.infrastructure.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserDB implements UserRepositoryInterface {

    private final UserRepository userRepository;

    @Autowired
    public UserDB(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Optional<User> getUserByID(UUID id) {
        return userRepository.findById(id);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
