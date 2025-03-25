package dev.members.interface_adapters.rest;

import dev.members.application.service.MemberManagementUseCase;
import dev.members.application.service.RenewMembershipUseCase;
import dev.members.infrastructure.model.entites.User;
import dev.members.interface_adapters.dto.CreateUserDTO;
import dev.members.interface_adapters.dto.RenewMembershipDTO;
import dev.members.interface_adapters.mapper.UserApiMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})

@RequestMapping("/member")
public class UserRenewMembership {
    private final RenewMembershipUseCase renewMembershipUseCase;
    private final MemberManagementUseCase memberManagementUseCase;

    @PostMapping("/renew-membership")
    public ResponseEntity<String> renewMembership(@RequestBody RenewMembershipDTO id) {
        renewMembershipUseCase.execute(UUID.fromString(id.getUserId()));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error in processing the request");
        }
        if(renewMembershipUseCase.isSuccessful(UUID.fromString(id.getUserId())))
        {
            return ResponseEntity.ok(
                    "Successfully renewed membership with id "
                            + id.getUserId()
                    );
        }
        else{
            return ResponseEntity.badRequest().body(
                    "Error in processing the request"
            );
        }


    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody CreateUserDTO userDTO) {
        UserApiMapper mapper = new UserApiMapper();
        memberManagementUseCase.
                createNewUser(mapper.userRequestDTOtoUserDomian(userDTO));

        return ResponseEntity.ok("user created successfully");

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                memberManagementUseCase.findUserById(id)
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(
                memberManagementUseCase.findUserByEmail(email)
        );
    }

}
