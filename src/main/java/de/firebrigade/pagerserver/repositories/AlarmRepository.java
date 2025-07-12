package de.firebrigade.pagerserver.repositories;

import de.firebrigade.pagerserver.entities.Alarm;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface AlarmRepository extends JpaRepository<Alarm, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE Alarm a SET a.message = :message WHERE a.id = :alarmId")
    int editAlarm(@Param("alarmId") UUID alarmId, @Param("message") String alarmMessage);

    @Query(value = "SELECT * FROM brigadepager.alarm ORDER BY time DESC LIMIT 1", nativeQuery = true)
    Optional<Alarm> getLatestAlarm();
}
