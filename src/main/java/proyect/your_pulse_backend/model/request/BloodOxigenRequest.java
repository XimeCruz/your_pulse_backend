package proyect.your_pulse_backend.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
public class BloodOxigenRequest {

    @NotNull(message = "Please enter o2")
    private Integer o2;

    @NotNull(message = "Please enter ID usuario")
    private String idUser;

    @NotNull(message = "Please enter date and hour")
    private Date date;


}
