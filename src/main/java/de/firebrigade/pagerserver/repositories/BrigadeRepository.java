package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Brigade;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BrigadeRepository extends JpaRepository<Brigade, UUID> {
}
