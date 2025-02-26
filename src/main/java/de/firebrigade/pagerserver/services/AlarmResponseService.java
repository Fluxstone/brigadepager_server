package de.firebrigade.pagerserver.services;

import de.firebrigade.pagerserver.entities.AlarmResponse;
import de.firebrigade.pagerserver.repositories.AlarmResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlarmResponseService {

    private final AlarmResponseRepository alarmResponseRepository;

    public List<AlarmResponse> getAllResponses() {
        return alarmResponseRepository.findAll();
    }

    public Optional<AlarmResponse> getResponseById(UUID id) {
        return alarmResponseRepository.findById(id);
    }

    public AlarmResponse saveResponse(AlarmResponse response) {
        return alarmResponseRepository.save(response);
    }

    public void deleteResponse(UUID id) {
        alarmResponseRepository.deleteById(id);
    }
}
