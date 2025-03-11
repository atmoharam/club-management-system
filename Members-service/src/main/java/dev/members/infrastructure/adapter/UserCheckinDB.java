package dev.members.infrastructure.adapter;

import dev.members.domain.repository.UserCheckinRepositoryInterface;
import dev.members.infrastructure.model.repository.UserCheckinRepository;

public class UserCheckinDB implements UserCheckinRepositoryInterface {
    private UserCheckinRepository checkinRepo;
}
