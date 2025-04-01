package de.firebrigade.pagerserver.controller;

import de.firebrigade.pagerserver.entities.DeviceTokenRequest;
import de.firebrigade.pagerserver.entities.Staff;
import de.firebrigade.pagerserver.entities.StaffNameChangeRequest;
import de.firebrigade.pagerserver.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable UUID id) {
        return staffService.getStaffById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Staff createStaff(@RequestBody Staff staff) {
        return staffService.saveStaff(staff);
    }

    @PostMapping("/deviceToken")
    public String manageDeviceToken(@RequestBody DeviceTokenRequest request) {
        return staffService.manageDeviceToken(request);
    }

    //TODO: This should be a editStaff function which takes a cert object, a staff object ect.
    @PostMapping("/changeName")
    public String changeName(@RequestBody StaffNameChangeRequest request) {
        return staffService.changeName(request);
    }

    @GetMapping("/getByEmail/{email}")
    public Optional<Staff> getStaffByEmail(@PathVariable String email) {
        return staffService.getStaffByEmail(email);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable UUID id) {
        staffService.deleteStaff(id);
        return ResponseEntity.noContent().build();
    }
}
