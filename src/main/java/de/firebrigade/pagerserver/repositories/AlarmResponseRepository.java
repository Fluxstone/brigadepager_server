package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.AlarmResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AlarmResponseRepository extends JpaRepository<AlarmResponse, UUID> {
}
