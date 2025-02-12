package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {
}

