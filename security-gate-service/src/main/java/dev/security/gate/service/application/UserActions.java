package dev.security.gate.service.application;

import dev.common.domain.cons.Action;
import dev.common.domain.cons.MembershipStatus;
import dev.kafka.service.model.dev.kafka.avro.SecurityAction;
import dev.security.gate.service.infrastructure.adapter.MembersDB;
import dev.security.gate.service.infrastructure.adapter.SecurityLogsDB;
import dev.security.gate.service.infrastructure.messaging.out.UserActionPublisher;
import dev.security.gate.service.infrastructure.model.entity.Member;
import dev.security.gate.service.infrastructure.model.entity.SecurityLog;
import dev.security.gate.service.interface_adapter.dto.ActionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserActions {
    @Autowired
    private SecurityLogsDB securityLogsDB;
    @Autowired
    private MembersDB membersDB;
    @Autowired
    private UserActionPublisher publisher;

    public ActionResponseDTO execute(UUID userId, String gate ,String action){
        Member member = membersDB.findById(userId).orElse(null);
        if(member == null){
            return ActionResponseDTO.builder()
                    .status("Failed")
                    .message("User Not Found")
                    .build();
        }
        if(member.getRenewalDate().isBefore(LocalDate.now())){
            member.setMembershipStatus(MembershipStatus.Expired.toString());
            membersDB.save(member);
            return ActionResponseDTO.builder()
                    .status("Failed")
                    .message("User Membership Expired")
                    .build();
        }
        SecurityLog securityLog = securityLogsDB.isUserLastActionCheckIn(userId).orElse(null);
        if ( Action.Check_out.toString().equals(action) && securityLog == null){
            return ActionResponseDTO.builder()
                    .status("Failed")
                    .message("User does not checked in")
                    .build();
        }

        SecurityLog object = SecurityLog.builder()
                .userId(userId)
                .gate(gate)
                .timestamp(Instant.now())
                .action(action)
                .build();

        securityLogsDB.save(object);

        SecurityAction securityAction = SecurityAction.newBuilder()
                .setActionId(UUID.randomUUID().toString())
                .setUserId(userId.toString())
                .setActionType(action)
                .build();
        publisher.publish(securityAction);

        return ActionResponseDTO.builder()
                .status("Success")
                .message("User" + userId + "/n"
                +action + " from gate : " + gate)
                .build();
    }

}
