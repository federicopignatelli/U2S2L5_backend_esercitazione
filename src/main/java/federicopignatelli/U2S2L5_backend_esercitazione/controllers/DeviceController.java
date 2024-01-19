package federicopignatelli.U2S2L5_backend_esercitazione.controllers;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.exception.BadRequestException;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserResponseDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.services.DeviceService;
import federicopignatelli.U2S2L5_backend_esercitazione.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewDeviceResponseDTO saveUser(@RequestBody @Validated NewUserDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors().toString());
        }
        User newUser = userService.save(body);
        return new NewUserResponseDTO(newUser.getId(), newUser.getName(), newUser.getSurname(), newUser.getEmail(), newUser.getUsername());
    }
}
