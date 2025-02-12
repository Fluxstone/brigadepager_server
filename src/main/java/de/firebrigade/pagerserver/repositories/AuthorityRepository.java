package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
