package proyect.your_pulse_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.your_pulse_backend.model.BloodPressure;
import proyect.your_pulse_backend.model.User;
import proyect.your_pulse_backend.model.request.BloodPressureRequest;
import proyect.your_pulse_backend.model.response.BloodPressureResponse;
import proyect.your_pulse_backend.repository.BloodPressureRepository;
import proyect.your_pulse_backend.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BloodPressureService {

    private final BloodPressureRepository bloodPressureRepository;
    private final UserRepository userRepository;

    public List<BloodPressure> getAllBloodPressure() {
        return bloodPressureRepository.findAll();
    }

    public List<BloodPressureResponse> getAllBloodPressureByUser(String idUser) {
        return bloodPressureRepository.getAllByUserId(idUser).stream()
                .map(result -> new BloodPressureResponse((Integer) result[0], (Integer) result[1],(Date) result[2]))
                .collect(Collectors.toList());
    }

    public BloodPressure insertBloodPressure(BloodPressureRequest bloodPressureRequest) {
        User user = userRepository.getUserById(bloodPressureRequest.getIdUser());

        BloodPressure bloodPressure = new BloodPressure();
        bloodPressure.setSys(bloodPressureRequest.getSys());
        bloodPressure.setDia(bloodPressureRequest.getDia());
        bloodPressure.setDate(bloodPressureRequest.getDate());
        bloodPressure.setUser(user);

        bloodPressureRepository.save(bloodPressure);

        return bloodPressure;
    }
}
