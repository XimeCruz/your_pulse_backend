package proyect.your_pulse_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proyect.your_pulse_backend.model.HeartRate;

import java.util.List;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {

    @Query("SELECT a.bpm, a.date FROM HeartRate a, User b  where a.user.id=b.id AND b.id=?1 ORDER BY a.date DESC")
    public List<Object[]> getAllHeartRateByUserId(String id);
}
