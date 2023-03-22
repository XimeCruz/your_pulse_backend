package proyect.your_pulse_backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyect.your_pulse_backend.model.User;
import proyect.your_pulse_backend.model.request.UserRequest;
import proyect.your_pulse_backend.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final Logger log =  LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> insertBloodOxigen(@Valid @RequestBody UserRequest userRequest, HttpServletRequest requestData)  {
        return  ResponseEntity.ok(userService.insertUser(userRequest));
    }


}
