package de.firebrigade.pagerserver.controller;

import de.firebrigade.pagerserver.entities.Certification;
import de.firebrigade.pagerserver.services.CertificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/certifications")
@RequiredArgsConstructor
public class CertificationController {

    private final CertificationService certificationService;

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certification> getCertificationById(@PathVariable UUID id) {
        return certificationService.getCertificationById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Certification createCertification(@RequestBody Certification certification) {
        return certificationService.saveCertification(certification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable UUID id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.noContent().build();
    }
}
