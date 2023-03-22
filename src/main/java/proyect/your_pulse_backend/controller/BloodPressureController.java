package proyect.your_pulse_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.your_pulse_backend.model.BloodPressure;
import proyect.your_pulse_backend.model.request.BloodPressureRequest;
import proyect.your_pulse_backend.model.response.BloodPressureResponse;
import proyect.your_pulse_backend.service.BloodPressureService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blood-pressure")
public class BloodPressureController {

    private final BloodPressureService bloodService;

    private final Logger log =  LoggerFactory.getLogger(BloodPressureController.class);

    public BloodPressureController(BloodPressureService bloodService) {
        this.bloodService = bloodService;
    }

    @GetMapping("/all")
    public List<BloodPressure> findAll() {
        log.info("REST request to get All Blood Oxigen");
        return bloodService.getAllBloodPressure();
    }


    @GetMapping("/idUser/{idUser}")
    public List<BloodPressureResponse> findAllBloodPressureByUser(@PathVariable("idUser") String idUser) {
        log.info("REST request to get All Blood Oxigen By User");
        return bloodService.getAllBloodPressureByUser(idUser);
    }


    @PostMapping
    public ResponseEntity<BloodPressure> insertBloodOxigen(@Valid @RequestBody BloodPressureRequest bloodPressureRequest, HttpServletRequest requestData)  {
        return  ResponseEntity.ok(bloodService.insertBloodPressure(bloodPressureRequest));
    }


}
