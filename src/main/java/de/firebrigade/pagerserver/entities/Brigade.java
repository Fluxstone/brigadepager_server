package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "brigade")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brigade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255, nullable = false, unique = true)
    private String name;
}
