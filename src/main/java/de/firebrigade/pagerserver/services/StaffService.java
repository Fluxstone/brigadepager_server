package de.firebrigade.pagerserver.services;

import de.firebrigade.pagerserver.entities.DeviceTokenRequest;
import de.firebrigade.pagerserver.entities.Staff;
import de.firebrigade.pagerserver.repositories.StaffRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffRepository staffRepository;

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    public Optional<Staff> getStaffById(UUID id) {
        return staffRepository.findById(id);
    }

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public void deleteStaff(UUID id) {
        staffRepository.deleteById(id);
    }

    public Optional<Staff> getStaffByEmail(String email){
        return Optional.ofNullable(staffRepository.getStaffByEmail(email));
    }

    public String manageDeviceToken(DeviceTokenRequest request){
        int updated = staffRepository.manageDeviceToken(request.getStaffId(), request.getDeviceToken());
        if (updated > 0) {
            return "Device token updated successfully.";
        } else {
            throw new EntityNotFoundException("Staff member not found.");
        }
    }
}
