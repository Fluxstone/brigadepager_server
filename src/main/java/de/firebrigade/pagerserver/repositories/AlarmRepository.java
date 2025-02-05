package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AlarmRepository extends JpaRepository<Alarm, UUID> {
}
