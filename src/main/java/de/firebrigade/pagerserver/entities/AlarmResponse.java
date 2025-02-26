package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "alarm_response")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlarmResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private UUID alarmId;

    @Column(nullable = false)
    private UUID staffId;

    @Column(nullable = false)
    private boolean response;

    @Column(nullable = false)
    private LocalDate timeDate;
}
