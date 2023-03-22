package proyect.your_pulse_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyect.your_pulse_backend.model.BloodPressure;

import java.util.List;

public interface BloodPressureRepository extends JpaRepository<BloodPressure, Long> {

    @Query("SELECT a.dia, a.sys, a.date FROM BloodPressure a, User b  where a.user.id=b.id AND b.id=?1 ORDER BY a.date DESC")
    public List<Object[]> getAllByUserId(String id);

}
