package dev.members.infrastructure.adapter;

import dev.members.domain.repository.UserSportRepositoryInterface;
import dev.members.infrastructure.model.entites.UserSport;
import dev.members.infrastructure.model.repository.UserCheckinRepository;
import dev.members.infrastructure.model.repository.UserSportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserSportDB implements UserSportRepositoryInterface {
    private UserSportRepository userSportRepository;

    public UserSport save(UserSport userSport) {
        return userSportRepository.save(userSport);
    }
    public Optional<UserSport> findById(UUID id) {
        return userSportRepository.findById(id);
    }
    public Optional<UserSport> findByUserId(UUID userId) {
        return userSportRepository.findByUserId(userId);
    }
}
