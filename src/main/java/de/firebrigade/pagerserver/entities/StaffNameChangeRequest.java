package de.firebrigade.pagerserver.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StaffNameChangeRequest {
    private UUID staffId;
    private String firstName;
    private String lastName;
}
