package proyect.your_pulse_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyect.your_pulse_backend.model.HeartRate;
import proyect.your_pulse_backend.model.request.HeartRateRequest;
import proyect.your_pulse_backend.model.response.HeartRateResponse;
import proyect.your_pulse_backend.service.HeartRateService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/heart-rate")
public class HeartRateController {

    private final HeartRateService heartRateService;

    private final Logger log =  LoggerFactory.getLogger(HeartRateController.class);

    public HeartRateController(HeartRateService heartRateService) {
        this.heartRateService = heartRateService;
    }

    @GetMapping("/all")
    public List<HeartRate> findAll() {
        log.info("REST request to get All Blood Oxigen");
        return heartRateService.getAllHeartRate();
    }


    @GetMapping("/idUser/{idUser}")
    public List<HeartRateResponse> findAllHeartRateByUser(@PathVariable("idUser") String idUser) {
        log.info("REST request to get All Blood Oxigen By User");
        return heartRateService.getAllHeartRateByUser(idUser);
    }


    @PostMapping
    public ResponseEntity<HeartRate> insertBloodOxigen(@Valid @RequestBody HeartRateRequest HeartRateRequest, HttpServletRequest requestData)  {
        return  ResponseEntity.ok(heartRateService.insertHeartRate(HeartRateRequest));
    }
    
//    @GetMapping
//    public List<HeartRateResponse> findAll() {
//        //log.info("REST request to get All Blood Oxigen");
//        return heartRateService.getAllHeartRate();
//    }
//
//    @PostMapping
//    public ResponseEntity<HeartRate> insertBloodOxigen(@Valid  @RequestBody HeartRateRequest heartRateRequest, HttpServletRequest requestData)  {
//        return  ResponseEntity.ok(heartRateService.insertHeartRace(heartRateRequest));
//    }


}
