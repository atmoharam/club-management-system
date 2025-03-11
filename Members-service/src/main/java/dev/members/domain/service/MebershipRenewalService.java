package dev.members.domain.service;

import dev.members.domain.model.entities.UserDomainEntity;

public class MebershipRenewalService {
    public void renewMembership(UserDomainEntity member){
        member.renewMembership();
    }

}
