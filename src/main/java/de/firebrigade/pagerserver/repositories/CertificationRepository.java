package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {
}