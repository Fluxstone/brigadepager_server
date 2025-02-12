package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Authority {

    @Id
    @Column(name = "username")
    private String username;  // Use username as the id

    @Column(nullable = false)
    private String authority;
}