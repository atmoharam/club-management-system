package dev.security.gate.service.interface_adapter.rest;

import dev.common.domain.cons.Action;
import dev.security.gate.service.application.UserActions;
import dev.security.gate.service.interface_adapter.dto.ActionRequestDTO;
import dev.security.gate.service.interface_adapter.dto.ActionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/security")
public class Controller {
    @Autowired
    UserActions userActions;
    @PostMapping("check_in")
    public ResponseEntity<ActionResponseDTO> ccheckIn(@RequestBody ActionRequestDTO actionRequestDTO){
        return ResponseEntity.ok(userActions.execute(actionRequestDTO.getId() , actionRequestDTO.getGate() , String.valueOf(Action.Check_in)));

    }

    @PostMapping("check_out")
    public ResponseEntity<ActionResponseDTO> checkOut(@RequestBody ActionRequestDTO actionRequestDTO){
        return ResponseEntity.ok(userActions.execute(actionRequestDTO.getId() , actionRequestDTO.getGate() , String.valueOf(Action.Check_out)));
    }
}
