package proyect.your_pulse_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@ToString
@Getter
@Setter
@Entity
@Table(name = "blood_oxigen")
public class BloodOxigen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private Integer o2;

    private Date date;

//    @ManyToOne
//    @JsonIgnoreProperties("")
//    private Sample sample;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;


}
