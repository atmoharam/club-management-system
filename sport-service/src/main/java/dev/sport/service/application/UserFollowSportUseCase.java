package dev.sport.service.application;

import dev.sport.service.domain.model.entites.UserSportDomainEntity;
import dev.sport.service.infrastructure.adapter.SportDB;
import dev.sport.service.infrastructure.adapter.UserSportFollowingDB;
import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.infrastructure.model.entites.UserSportFollowing;
import dev.sport.service.infrastructure.model.mapper.SportMapper;
import dev.sport.service.infrastructure.model.mapper.UserSportFollowingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserFollowSportUseCase {
    final UserSportFollowingDB userSportFollowingDB;
    final UserSportFollowingMapper userSportFollowingMapper;
    final SportMapper sportMapper;
    final SportDB sportDB;
    @Autowired
    public UserFollowSportUseCase(UserSportFollowingDB userSportFollowingDB, UserSportFollowingMapper userSportFollowingMapper, SportMapper sportMapper, SportDB sportDB) {
        this.userSportFollowingDB = userSportFollowingDB;
        this.userSportFollowingMapper = userSportFollowingMapper;
        this.sportMapper = sportMapper;
        this.sportDB = sportDB;
    }

    public void process(UUID userId , UUID sportId) {
        Sport sport = sportDB.findById(sportId).orElse(null);
        if (sport != null) {
            UserSportFollowing sportFollowing =
                    UserSportFollowing.builder()
                            .userId(userId)
                            .sport(sport)
                            .build();
            userSportFollowingDB.save(sportFollowing);
        }
    }
}
