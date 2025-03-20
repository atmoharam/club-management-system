package dev.sport.service.interface_adapters.rest;

import dev.sport.service.application.SessionUseCase;
import dev.sport.service.application.SportManagementUseCase;
import dev.sport.service.interface_adapters.dto.SessionDTO;
import dev.sport.service.interface_adapters.dto.SportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sport")
public class Controller {
    final SportManagementUseCase sportManagementUseCase;
    final SessionUseCase sessionUseCase;
    @Autowired
    public Controller(SportManagementUseCase sportManagementUseCase, SessionUseCase sessionUseCase) {
        this.sportManagementUseCase = sportManagementUseCase;
        this.sessionUseCase = sessionUseCase;
    }

    @PostMapping("/create")
    public String create(@RequestBody SportDTO object) {
        sportManagementUseCase.createSport(object.getName(), object.getDescription());
        return "Success";
    }

    @PostMapping("/session")
    public String session(@RequestBody SessionDTO object) {
        sessionUseCase.createSession(object);
        return "Success";
    }

}
