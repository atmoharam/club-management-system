package dev.members.interface_adapters.rest;

import dev.members.application.service.RelationshipsUseCase;
import dev.members.infrastructure.model.entites.FamilyMember;
import dev.members.interface_adapters.dto.DeleteRelationDTO;
import dev.members.interface_adapters.dto.GenericUUID;
import dev.members.interface_adapters.dto.RelationDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@RequestMapping("/member/relationship")
public class RelationshipsController {

    private final RelationshipsUseCase relationshipsUseCase;

    @PostMapping
    public ResponseEntity<FamilyMember> create(@RequestBody RelationDTO relationDTO) {

        return ResponseEntity.ok(
                relationshipsUseCase.
                        create(UUID.fromString(relationDTO.getFirstUserId())
                                ,UUID.fromString(relationDTO.getSecondUserId()),
                                relationDTO.getRelationType())

        );
    }
    @GetMapping("/all")
    public ResponseEntity<List<FamilyMember>>getAll(@RequestBody GenericUUID req) {
        return ResponseEntity.ok(
                relationshipsUseCase.findAll(req.getId())
        );
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody DeleteRelationDTO deleteRelationDTO) {
        relationshipsUseCase.delete(
                deleteRelationDTO.getFirstUserId() ,
                deleteRelationDTO.getSecondUserId());
        return ResponseEntity.accepted().body(
                "Relation between (" + deleteRelationDTO.getFirstUserId() +
                        " , " + deleteRelationDTO.getSecondUserId() + " ) " +
                        "has been deleted"
        );
    }



}
