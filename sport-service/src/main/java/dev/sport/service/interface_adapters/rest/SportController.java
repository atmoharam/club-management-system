package dev.sport.service.interface_adapters.rest;

import dev.sport.service.application.SportManagementUseCase;
import dev.sport.service.infrastructure.model.entites.Sport;
import dev.sport.service.interface_adapters.dto.GenericUUID;
import dev.sport.service.interface_adapters.dto.SportDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sport")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class SportController {

    final SportManagementUseCase sportManagementUseCase;

    @PostMapping
    public String create(@RequestBody SportDTO object) {
        sportManagementUseCase.createSport(object.getName(), object.getDescription());
        return "Success";
    }
    @GetMapping("/all")
    public ResponseEntity<List<Sport>> getAll() {
        return ResponseEntity.ok(sportManagementUseCase.getAllSports());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Optional<Sport>> getBySportName(@PathVariable String name) {
        return ResponseEntity.ok(
                sportManagementUseCase.getSportByName(name)
        );
    }
    @DeleteMapping
    public ResponseEntity<String> deleteBySportId(@RequestBody GenericUUID request) {
        sportManagementUseCase.deleteSport(request.getValue());
        return ResponseEntity.ok("Deleted successfully");
    }
    @PutMapping
    public ResponseEntity<String> update(@RequestBody SportDTO object) {
        sportManagementUseCase.
                updateSport(object.getName() , object.getDescription());
        return ResponseEntity.ok("Updated successfully");
    }

}
