package dev.security.gate.service.interface_adapter.rest;

import dev.common.domain.cons.Action;
import dev.security.gate.service.application.UserActions;
import dev.security.gate.service.infrastructure.model.entity.SecurityLog;
import dev.security.gate.service.interface_adapter.dto.ActionRequestDTO;
import dev.security.gate.service.interface_adapter.dto.ActionResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/security")
public class Controller {
    @Autowired
    UserActions userActions;
    @PostMapping("/check_in")
    public ResponseEntity<ActionResponseDTO> checkIn(@RequestBody ActionRequestDTO actionRequestDTO){
        return ResponseEntity.ok(userActions.execute(actionRequestDTO.getId() , actionRequestDTO.getGate() , String.valueOf(Action.Check_in)));

    }

    @PostMapping("/check_out")
    public ResponseEntity<ActionResponseDTO> checkOut(@RequestBody ActionRequestDTO actionRequestDTO){
        return ResponseEntity.ok(userActions.execute(actionRequestDTO.getId() , actionRequestDTO.getGate() , String.valueOf(Action.Check_out)));
    }

    @GetMapping("/count-now")
    public ResponseEntity<Long> getCount()
    {
        return ResponseEntity.ok(userActions.onlineUserCount());
    }

    @GetMapping("/gate/{gate}")
    public ResponseEntity<List<SecurityLog>> getByGate(@PathVariable String gate)
    {
        return ResponseEntity.ok(userActions.gateActions(gate));
    }
}
