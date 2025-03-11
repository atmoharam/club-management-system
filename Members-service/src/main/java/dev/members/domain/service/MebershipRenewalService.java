package dev.members.domain.service;

import dev.members.domain.model.entities.UserDomainEntity;
import org.springframework.stereotype.Service;

@Service
public class MebershipRenewalService {

    public void initRenewMembership(UserDomainEntity member) {
        member.initRenewMembership();

    }

    public void renewMembership(UserDomainEntity member){
        member.renewMembership();
    }

}
