package proyect.your_pulse_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.your_pulse_backend.model.HeartRate;
import proyect.your_pulse_backend.model.User;
import proyect.your_pulse_backend.model.request.HeartRateRequest;
import proyect.your_pulse_backend.model.response.HeartRateResponse;
import proyect.your_pulse_backend.repository.HeartRateRepository;
import proyect.your_pulse_backend.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class HeartRateService {

    private final HeartRateRepository heartRateRepository;
    private final UserRepository userRepository;

    public List<HeartRate> getAllHeartRate() {
        return heartRateRepository.findAll();
    }

    public List<HeartRateResponse> getAllHeartRateByUser(String idUser) {
        return heartRateRepository.getAllHeartRateByUserId(idUser).stream()
                .map(result -> new HeartRateResponse((Integer) result[0], (Date) result[1]))
                .collect(Collectors.toList());
    }

    public HeartRate insertHeartRate(HeartRateRequest heartRateRequest) {
        User user = userRepository.getUserById(heartRateRequest.getIdUser());

        HeartRate heartRate = new HeartRate();
        heartRate.setBpm(heartRateRequest.getBpm());
        heartRate.setDate(heartRateRequest.getDate());
        heartRate.setUser(user);

        heartRateRepository.save(heartRate);

        return heartRate;
    }

}
