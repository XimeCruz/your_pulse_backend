package proyect.your_pulse_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyect.your_pulse_backend.model.BloodOxigen;

import java.util.List;

public interface BloodOxigenRepository extends JpaRepository<BloodOxigen, Long> {

    @Query("SELECT a.o2, a.date FROM BloodOxigen a, User b  where a.user.id=b.id AND b.id=?1 ORDER BY a.date DESC")
    public List<Object[]> getAllByUserId(String id);


}
