package proyect.your_pulse_backend.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class HeartRateResponse {

    private Integer bpm;

    private Date date;
}
