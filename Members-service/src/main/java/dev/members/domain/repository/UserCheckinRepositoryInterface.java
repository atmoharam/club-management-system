package dev.members.domain.repository;

import dev.members.infrastructure.model.entites.UserCheckIn;

public interface UserCheckinRepositoryInterface {
    public UserCheckIn save(UserCheckIn userCheckIn);
}
