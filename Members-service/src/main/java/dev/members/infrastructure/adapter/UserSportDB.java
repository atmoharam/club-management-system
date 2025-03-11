package dev.members.infrastructure.adapter;

import dev.members.domain.repository.UserSportRepositoryInterface;
import dev.members.infrastructure.model.repository.UserCheckinRepository;

public class UserSportDB implements UserSportRepositoryInterface {
    private UserCheckinRepository checkinRepository;
}
