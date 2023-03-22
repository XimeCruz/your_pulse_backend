package proyect.your_pulse_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.your_pulse_backend.model.BloodOxigen;
import proyect.your_pulse_backend.model.request.BloodOxigenRequest;
import proyect.your_pulse_backend.model.response.BloodOxigenResponse;
import proyect.your_pulse_backend.service.BloodOxigenService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/blood-oxigen")
public class BloodOxigenController {

    private final BloodOxigenService bloodService;

    private final Logger log =  LoggerFactory.getLogger(BloodOxigenController.class);

    public BloodOxigenController(BloodOxigenService bloodService) {
        this.bloodService = bloodService;
    }

    @GetMapping("/all")
    public List<BloodOxigen> findAll() {
        log.info("REST request to get All Blood Oxigen");
        return bloodService.getAllBloodOxigen();
    }


    @GetMapping("/idUser/{idUser}")
    public List<BloodOxigenResponse> findAllBloodOxigenByUser(@PathVariable("idUser") String idUser) {
        log.info("REST request to get All Blood Oxigen By User Id");
        return bloodService.getAllBloodOxigenByUser(idUser);
    }


    @PostMapping
    public ResponseEntity<BloodOxigen> insertBloodOxigen(@Valid @RequestBody BloodOxigenRequest bloodOxigenRequest, HttpServletRequest requestData)  {
        log.info("REST request to insert Blood Oxigen");
        return  ResponseEntity.ok(bloodService.insertBloodOxigen(bloodOxigenRequest));
    }

    //sacar max min y media de all y por fechas
    @GetMapping("/report/{idUser}/{dateStart}/{dateEnd}")
    public List<BloodOxigenResponse> reportBloodOxigenByUser(@PathVariable("idUser") String idUser) {
        log.info("REST request to get All Blood Oxigen By User Id");
        return bloodService.getAllBloodOxigenByUser(idUser);
    }


}
