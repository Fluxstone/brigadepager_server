package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}

