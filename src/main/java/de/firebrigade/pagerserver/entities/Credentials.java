package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "credentials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credentials {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 120, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String pw;
}
