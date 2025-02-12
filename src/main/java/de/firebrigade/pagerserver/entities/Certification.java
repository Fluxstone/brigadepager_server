package de.firebrigade.pagerserver.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "certification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private boolean truppmann;
    private boolean atemschutzGeraetetraeger;
    private boolean truppfuehrer;
    private boolean gruppenfuehrer;
    private boolean maschinist;
    private boolean zugfuehrer;
    private boolean sanitaeter;
}
