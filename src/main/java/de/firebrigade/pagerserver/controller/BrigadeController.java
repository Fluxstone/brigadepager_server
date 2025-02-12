package de.firebrigade.pagerserver.controller;

import de.firebrigade.pagerserver.entities.Brigade;
import de.firebrigade.pagerserver.services.BrigadeService;
import de.firebrigade.pagerserver.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brigades")
@RequiredArgsConstructor
public class BrigadeController {

    private final BrigadeService brigadeService;
    private final UserService userService;

    @GetMapping
    public List<Brigade> getAllBrigades() {
        return brigadeService.getAllBrigades();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brigade> getBrigadeById(@PathVariable UUID id) {
        System.out.println(userService.getAllUsers());
        return brigadeService.getBrigadeById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Brigade createBrigade(@RequestBody Brigade brigade) {
        return brigadeService.saveBrigade(brigade);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrigade(@PathVariable UUID id) {
        brigadeService.deleteBrigade(id);
        return ResponseEntity.noContent().build();
    }
}
