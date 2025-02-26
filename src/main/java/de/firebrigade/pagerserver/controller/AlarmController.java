package de.firebrigade.pagerserver.controller;

import de.firebrigade.pagerserver.entities.Alarm;
import de.firebrigade.pagerserver.services.AlarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/alarms")
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmService alarmService;

    //TODO: Check for Pagination
    @GetMapping
    public List<Alarm> getAllAlarms() {
        return alarmService.getAllAlarms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alarm> getAlarmById(@PathVariable UUID id) {
        return alarmService.getAlarmById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alarm createAlarm(@RequestBody Alarm alarm) {
        return alarmService.saveAlarm(alarm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlarm(@PathVariable UUID id) {
        alarmService.deleteAlarm(id);
        return ResponseEntity.noContent().build();
    }
}
