package de.firebrigade.pagerserver.services;

import de.firebrigade.pagerserver.entities.Alarm;
import de.firebrigade.pagerserver.repositories.AlarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;

    public List<Alarm> getAllAlarms() {
        return alarmRepository.findAll();
    }

    public Optional<Alarm> getAlarmById(UUID id) {
        return alarmRepository.findById(id);
    }

    public Alarm saveAlarm(Alarm alarm) {
        return alarmRepository.save(alarm);
    }

    public void deleteAlarm(UUID id) {
        alarmRepository.deleteById(id);
    }
}
