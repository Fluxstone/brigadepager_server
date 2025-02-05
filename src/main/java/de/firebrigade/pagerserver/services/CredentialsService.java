package de.firebrigade.pagerserver.services;

import de.firebrigade.pagerserver.entities.Credentials;
import de.firebrigade.pagerserver.repositories.CredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Credentials> getAllCredentials() {
        return credentialsRepository.findAll();
    }

    public Optional<Credentials> getCredentialsById(UUID id) {
        return credentialsRepository.findById(id);
    }

    public Optional<Credentials> getCredentialsByEmail(String email) {
        return credentialsRepository.findByEmail(email);
    }

    public Credentials saveCredentials(Credentials credentials) {
        credentials.setPw(passwordEncoder.encode(credentials.getPw())); // Hash password before saving
        return credentialsRepository.save(credentials);
    }

    public void deleteCredentials(UUID id) {
        credentialsRepository.deleteById(id);
    }
}
