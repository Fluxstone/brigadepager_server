package de.firebrigade.pagerserver.services;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import de.firebrigade.pagerserver.entities.Alarm;
import de.firebrigade.pagerserver.entities.EditAlarmRequest;
import de.firebrigade.pagerserver.repositories.AlarmRepository;
import de.firebrigade.pagerserver.repositories.StaffRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;
    private final StaffRepository staffRepository;

    public List<Alarm> getAllAlarms() {
        return alarmRepository.findAll();
    }

    public Optional<Alarm> getAlarmById(UUID id) {
        return alarmRepository.findById(id);
    }

    public Alarm getLatestAlarm(){
        return alarmRepository.getLatestAlarm().orElse(new Alarm());
    };

    public Alarm saveAlarm(Alarm alarm) {
        //1. Get list of all Recipients (in staff get all device tokens
        List<String> deviceTokenList = staffRepository.getAllDeviceTokens();

        //2. Save alarm
        alarmRepository.save(alarm);

        //3. If successfull send messages to devices
        for (int i = 0; i < deviceTokenList.size(); i++) {
            try {
                buildAlarmNotification(alarm, deviceTokenList.get(i));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return alarm;
    }

    //TODO: Return edited alarm
    public String editAlarm(EditAlarmRequest request) {
        int updated = alarmRepository.editAlarm(request.getAlarmId(), request.getAlarmMessage());
        if (updated > 0) {
            return "Alarm updated successfully.";
        } else {
            throw new EntityNotFoundException("Staff member not found.");
        }
    }

    public void deleteAlarm(UUID id) {
        alarmRepository.deleteById(id);
    }

    private void buildAlarmNotification(Alarm alarm, String deviceToken) throws FirebaseMessagingException {
        LocalDateTime dateTime = alarm.getTime();
        String alarmMessage = alarm.getMessage();


        Message message = Message.builder()
                .putData("dateTime", dateTime.toString())
                .setNotification(Notification.builder()
                        .setTitle("New Alarm")
                        .setBody(alarmMessage)
                        .build())
                .setToken(deviceToken)
                .build();
        FirebaseMessaging.getInstance().send(message);
    }
}