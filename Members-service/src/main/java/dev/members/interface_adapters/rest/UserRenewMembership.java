package dev.members.interface_adapters.rest;

import dev.members.application.service.CreateNewMemberUseCase;
import dev.members.application.service.CreateRelationshipUseCase;
import dev.members.application.service.RenewMembershipUseCase;
import dev.members.application.service.SubscribeSportUseCase;
import dev.members.interface_adapters.dto.CreateUserDTO;
import dev.members.interface_adapters.dto.RelationDTO;
import dev.members.interface_adapters.dto.RenewMembershipDTO;
import dev.members.interface_adapters.dto.SubSportDTO;
import dev.members.interface_adapters.mapper.UserApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class UserRenewMembership {
    @Autowired
    private final RenewMembershipUseCase renewMembershipUseCase;
    @Autowired
    private final CreateNewMemberUseCase createNewMemberUseCase;
    @Autowired
    private final CreateRelationshipUseCase createRelationshipUseCase;
    @Autowired
    private final SubscribeSportUseCase subscribeSportUseCase;

    @PostMapping("/renew-membership")
    public ResponseEntity<String> renewMembership(@RequestBody RenewMembershipDTO id) {
        renewMembershipUseCase.execute(UUID.fromString(id.getUserId()));
        return ResponseEntity.ok("HI");
    }

    @PostMapping
    public ResponseEntity<String> creteUser(@RequestBody CreateUserDTO userDTO) {
        UserApiMapper mapper = new UserApiMapper();
        createNewMemberUseCase.
                createNewUser(mapper.userRequestDTOtoUserDomian(userDTO));
        return ResponseEntity.ok("user created successfully");

    }

    @PostMapping("/relationship")
    public ResponseEntity<String> relationship(@RequestBody RelationDTO relationDTO) {
        createRelationshipUseCase.
                execute(UUID.fromString(relationDTO.getFirstUserId())
                ,UUID.fromString(relationDTO.getSecondUserId()),
                        relationDTO.getRelationType());
        return ResponseEntity.ok("relationship created successfully");
    }

    @PostMapping("subscribe-sport")
    public ResponseEntity<String> subscribeSport(@RequestBody SubSportDTO subSport){
        subscribeSportUseCase.execute(
                UUID.fromString(subSport.getUserID()),
                UUID.fromString(subSport.getSportID())
        );
        return ResponseEntity.ok("subscribe sport created successfully");
    }

}
