package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(nullable = false)
    private UUID brigadeId;

    @Column(nullable = false)
    private UUID certificationId;

    @Column(nullable = false)
    private UUID credentialsId;

    private boolean isAdmin;
}
