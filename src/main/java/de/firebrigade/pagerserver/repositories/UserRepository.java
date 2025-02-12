package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
