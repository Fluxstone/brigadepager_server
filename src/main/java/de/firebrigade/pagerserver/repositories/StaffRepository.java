package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Staff;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Staff s SET s.deviceToken = :deviceToken WHERE s.id = :staffId")
    int manageDeviceToken(@Param("staffId") UUID staffId, @Param("deviceToken") String deviceToken);

    @Transactional
    @Query("SELECT s FROM Staff s WHERE s.credentialsId = :credentialsId")
    Staff getStaffByEmail(@Param("credentialsId") String credentialsId);

    @Transactional
    @Query("SELECT s.deviceToken FROM Staff s WHERE s.deviceToken IS NOT NULL")
    List<String> getAllDeviceTokens();

}

