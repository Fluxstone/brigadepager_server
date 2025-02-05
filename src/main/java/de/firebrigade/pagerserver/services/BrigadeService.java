package de.firebrigade.pagerserver.services;

import de.firebrigade.pagerserver.entities.Brigade;
import de.firebrigade.pagerserver.repositories.BrigadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrigadeService {

    private final BrigadeRepository brigadeRepository;

    public List<Brigade> getAllBrigades() {
        return brigadeRepository.findAll();
    }

    public Optional<Brigade> getBrigadeById(UUID id) {
        return brigadeRepository.findById(id);
    }

    public Brigade saveBrigade(Brigade brigade) {
        return brigadeRepository.save(brigade);
    }

    public void deleteBrigade(UUID id) {
        brigadeRepository.deleteById(id);
    }
}
