package dev.members.interface_adapters.rest;

import dev.members.application.service.RenewMembershipUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api")
public class UserRenewMembership {
    private final RenewMembershipUseCase renewMembershipUseCase = new RenewMembershipUseCase();

    @PostMapping
    public ResponseEntity<String> renewMembership(@RequestBody String userId) {
        UUID uuid = UUID.fromString(userId);
        renewMembershipUseCase.execute(uuid);
        return ResponseEntity.ok("HI");
    }

}
