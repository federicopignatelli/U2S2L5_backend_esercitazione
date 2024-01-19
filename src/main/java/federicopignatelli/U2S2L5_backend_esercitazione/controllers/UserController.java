package federicopignatelli.U2S2L5_backend_esercitazione.controllers;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserResponseDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    //save user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewUserResponseDTO saveUser(@RequestBody @Validated NewUserDTO body, BindingResult validation) throws Exception {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        Author newAuthor = authorsService.save(body);
        return new NewAuthorResponseDTO(newAuthor.getId());
    }



}
