package de.firebrigade.pagerserver.controller;

import de.firebrigade.pagerserver.entities.Credentials;
import de.firebrigade.pagerserver.services.CredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/credentials")
@RequiredArgsConstructor
public class CredentialsController {

    private final CredentialsService credentialsService;

    @GetMapping
    public List<Credentials> getAllCredentials() {
        return credentialsService.getAllCredentials();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Credentials> getCredentialsById(@PathVariable UUID id) {
        return credentialsService.getCredentialsById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Credentials> getCredentialsByEmail(@PathVariable String email) {
        return credentialsService.getCredentialsByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Credentials createCredentials(@RequestBody Credentials credentials) {
        return credentialsService.saveCredentials(credentials);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCredentials(@PathVariable UUID id) {
        credentialsService.deleteCredentials(id);
        return ResponseEntity.noContent().build();
    }
}
