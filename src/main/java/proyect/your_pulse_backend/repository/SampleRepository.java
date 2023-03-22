package proyect.your_pulse_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proyect.your_pulse_backend.model.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {
}
