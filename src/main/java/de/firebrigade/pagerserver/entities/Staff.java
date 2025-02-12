package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "staff")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(nullable = false)
    private UUID brigadeId;

    @Column(nullable = false)
    private UUID certificationId;

    @Column(nullable = false, length = 255)
    private String credentialsMail;

    private boolean isAdmin;
}
