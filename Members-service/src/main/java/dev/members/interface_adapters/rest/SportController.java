package dev.members.interface_adapters.rest;

import dev.members.application.service.SubscribeSportUseCase;
import dev.members.infrastructure.adapter.UserSportDB;
import dev.members.infrastructure.model.entites.UserSport;
import dev.members.interface_adapters.dto.SubSportDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@RequestMapping("/member/sport")
public class SportController {
    private final SubscribeSportUseCase subscribeSportUseCase;

    @PostMapping("subscribe-sport")
    public ResponseEntity<String> subscribeSport(@RequestBody SubSportDTO subSport){
        subscribeSportUseCase.sending(
                UUID.fromString(subSport.getUserID()),
                UUID.fromString(subSport.getSportID())
        );
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error in processing the request");
        }

        if(subscribeSportUseCase.isSuccess(UUID.fromString(subSport.getUserID())))
        {
            return ResponseEntity.ok(
                    "User " + subSport.getUserID()
                            + " subscribed to sport " +
                            subSport.getSportID()

            );
        }
        else{
            return ResponseEntity.ok("Error in Payment transaction");
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSport> getUserSport(@PathVariable UUID id){
        return ResponseEntity.ok(subscribeSportUseCase.getUserSport(id));
    }
}
