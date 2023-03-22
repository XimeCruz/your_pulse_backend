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
@Table(name = "blood_pressure")
public class BloodPressure implements Serializable {

//    @Id
//    @GeneratedValue(generator = "blood_gen", strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "blood_gen", sequenceName = "blood_gen",initialValue = 1, allocationSize = 1)
//    @Column(name = "id", nullable = false)

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    private Integer sys;

    private Integer dia;

    private Date date;

//    @ManyToOne
//    @JsonIgnoreProperties("")
//    private Sample sample;

    @ManyToOne
    @JsonIgnoreProperties("")
    private User user;

}
