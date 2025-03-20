package dev.members.infrastructure.adapter;

import dev.members.domain.repository.UserCheckinRepositoryInterface;
import dev.members.infrastructure.model.entites.UserCheckIn;
import dev.members.infrastructure.model.repository.UserCheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCheckinDB implements UserCheckinRepositoryInterface {

    @Autowired
    private UserCheckinRepository userCheckinRepository;

    @Override
    public UserCheckIn save(UserCheckIn userCheckIn) {
        return userCheckinRepository.save(userCheckIn);
    }
}
