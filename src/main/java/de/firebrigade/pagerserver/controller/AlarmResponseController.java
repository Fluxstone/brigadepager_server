package de.firebrigade.pagerserver.controller;

import de.firebrigade.pagerserver.entities.AlarmResponse;
import de.firebrigade.pagerserver.services.AlarmResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/alarm-responses")
@RequiredArgsConstructor
public class AlarmResponseController {

    private final AlarmResponseService alarmResponseService;

    @GetMapping
    public List<AlarmResponse> getAllResponses() {
        return alarmResponseService.getAllResponses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlarmResponse> getResponseById(@PathVariable UUID id) {
        Optional<AlarmResponse> response = alarmResponseService.getResponseById(id);
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AlarmResponse createResponse(@RequestBody AlarmResponse response) {
        return alarmResponseService.saveResponse(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable UUID id) {
        alarmResponseService.deleteResponse(id);
        return ResponseEntity.noContent().build();
    }
}
