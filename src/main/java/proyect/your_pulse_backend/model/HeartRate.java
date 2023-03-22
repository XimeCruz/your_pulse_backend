package proyect.your_pulse_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "heart_rate")
public class HeartRate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private Integer bpm;

    private Date date;

//    @ManyToOne
//    @JsonIgnoreProperties("")
//    private Sample sample;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;

}
