package proyect.your_pulse_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyect.your_pulse_backend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User getUserById(String id);

}
