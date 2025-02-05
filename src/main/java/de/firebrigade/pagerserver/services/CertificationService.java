package de.firebrigade.pagerserver.services;

import de.firebrigade.pagerserver.entities.Certification;
import de.firebrigade.pagerserver.repositories.CertificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Optional<Certification> getCertificationById(UUID id) {
        return certificationRepository.findById(id);
    }

    public Certification saveCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public void deleteCertification(UUID id) {
        certificationRepository.deleteById(id);
    }
}
