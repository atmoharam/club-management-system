package dev.sport.service.interface_adapters.rest;

import dev.sport.service.application.SessionUseCase;
import dev.sport.service.infrastructure.model.entites.SportSession;
import dev.sport.service.interface_adapters.dto.SessionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sport/session")
public class SessionsController {
    final SessionUseCase sessionUseCase;
    @Autowired
    public SessionsController(SessionUseCase sessionUseCase) {
        this.sessionUseCase = sessionUseCase;
    }

    @PostMapping
    public String session(@RequestBody SessionDTO object) {
        sessionUseCase.createSession(object);
        return "Success";
    }

    @GetMapping("id/{id}")
    public SportSession getSportSession(@PathVariable String id) {
        return sessionUseCase.getSession(UUID.fromString(id));
    }

    @GetMapping("sport-name/{name}")
    public List<SportSession> getSportSessionsBySport(@PathVariable String name) {
        return sessionUseCase.getSessionBySportName(name);
    }
    @GetMapping("trainer/{id}")
    public List<SportSession> getSportSessionsByTrainer(@PathVariable String id) {
        return sessionUseCase.getSessionByTrainerId(UUID.fromString(id));
    }

}
