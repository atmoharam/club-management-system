package dev.sport.service.infrastructure.adapter;

import dev.sport.service.domain.repository.UserSportFollowingRepositoryInterface;
import dev.sport.service.infrastructure.model.entites.UserSportFollowing;
import dev.sport.service.infrastructure.model.repository.UserSportFollowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSportFollowingDB implements UserSportFollowingRepositoryInterface {
    final UserSportFollowingRepository sportFollowingRepository;

    public UserSportFollowingDB(UserSportFollowingRepository sportFollowingRepository) {
        this.sportFollowingRepository = sportFollowingRepository;
    }

    @Override
    public UserSportFollowing save(UserSportFollowing userSportFollowing) {
        return sportFollowingRepository.save(userSportFollowing);
    }
}
