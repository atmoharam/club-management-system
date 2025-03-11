package dev.members.infrastructure.adapter;

import dev.members.domain.repository.UserCheckinRepositoryInterface;
import dev.members.infrastructure.model.entites.User;
import dev.members.infrastructure.model.repository.UserCheckinRepository;
import dev.members.infrastructure.model.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class UserDB implements UserCheckinRepositoryInterface {
    private UserRepository userRepository;
    public Optional<User> getUserByID(UUID id) {
        return userRepository.findById(id);
    }
}
