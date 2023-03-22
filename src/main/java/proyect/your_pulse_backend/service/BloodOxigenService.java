package proyect.your_pulse_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.your_pulse_backend.model.BloodOxigen;
import proyect.your_pulse_backend.model.User;
import proyect.your_pulse_backend.model.request.BloodOxigenRequest;
import proyect.your_pulse_backend.model.response.BloodOxigenResponse;
import proyect.your_pulse_backend.repository.BloodOxigenRepository;
import proyect.your_pulse_backend.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BloodOxigenService {

    private final BloodOxigenRepository bloodOxigenRepository;
    private final UserRepository userRepository;

    public List<BloodOxigen> getAllBloodOxigen() {
        return bloodOxigenRepository.findAll();
    }

    public List<BloodOxigenResponse> getAllBloodOxigenByUser(String idUser) {
        return bloodOxigenRepository.getAllByUserId(idUser).stream()
                .map(result -> new BloodOxigenResponse((Integer) result[0], (Date) result[1]))
                .collect(Collectors.toList());
    }

    public BloodOxigen insertBloodOxigen(BloodOxigenRequest bloodOxigenRequest) {
        User user = userRepository.getUserById(bloodOxigenRequest.getIdUser());


        BloodOxigen bloodOxigen = new BloodOxigen();
        bloodOxigen.setO2(bloodOxigenRequest.getO2());
        bloodOxigen.setDate(bloodOxigenRequest.getDate());
        bloodOxigen.setUser(user);

        bloodOxigenRepository.save(bloodOxigen);

        return bloodOxigen;
    }

//    public List<BloodOxigenResponse> getAllBloodOxigen() {
//        return bloodOxigenRepository.getAllByOrderByBloodOxigenDateDesc().stream()
//                .map(result -> new BloodOxigenResponse((Integer) result[0], (Date) result[1]))
//                .collect(Collectors.toList());
//    }
//
//    public List<BloodOxigenResponse> getAllBloodOxigenByUser(String idUser) {
//        return bloodOxigenRepository.getAllByOrderByBloodOxigenAndUserIdDateDesc(idUser).stream()
//                .map(result -> new BloodOxigenResponse((Integer) result[0], (Date) result[1]))
//                .collect(Collectors.toList());
//    }
//
//    public BloodOxigen insertBloodOxigen(BloodOxigenRequest bloodOxigenRequest) {
//        User user = userRepository.getUserById(bloodOxigenRequest.getIdUser());
//
//        Sample sample = new Sample();
//        sample.setDate(bloodOxigenRequest.getDate());
//        sample.setUser(user);
//
//        sampleRepository.save(sample);
//
//        BloodOxigen bloodOxigen = new BloodOxigen();
//        bloodOxigen.setO2(bloodOxigenRequest.getO2());
//        bloodOxigen.setSample(sample);
//
//        bloodOxigenRepository.save(bloodOxigen);
//
//        return bloodOxigen;
//    }


}
