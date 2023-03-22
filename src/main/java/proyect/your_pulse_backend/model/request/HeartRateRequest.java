package proyect.your_pulse_backend.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class HeartRateRequest {

    @NotNull(message = "Please enter bpm")
    private Integer bpm;

    @NotNull(message = "Please enter ID usuario")
    private String idUser;

    @NotNull(message = "Please enter date and hour")
    private Date date;


}
