package proyect.your_pulse_backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proyect.your_pulse_backend.model.User;
import proyect.your_pulse_backend.model.request.UserRequest;
import proyect.your_pulse_backend.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User insertUser(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setAge(userRequest.getAge());
        user.setAddress(userRequest.getAddress());
        user.setImageUrl(userRequest.getImageUrl());

        user.setStatus(true);

        userRepository.save(user);

        return user;
    }
}
