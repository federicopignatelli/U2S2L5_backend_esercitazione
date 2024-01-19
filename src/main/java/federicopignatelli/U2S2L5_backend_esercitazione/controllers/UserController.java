package federicopignatelli.U2S2L5_backend_esercitazione.controllers;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.exception.BadRequestException;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserResponseDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
            throw new BadRequestException(validation.getAllErrors().toString());
        }
        User newUser = userService.save(body);
        return new NewUserResponseDTO(newUser.getId(), newUser.getName(), newUser.getSurname(), newUser.getEmail(), newUser.getUsername());
    }

    //get user
    @GetMapping("")
    public Page<User> getUser(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getUser(page, size, sortBy);
    }

    //get user by id
    @GetMapping("/{userId}")
    public User findById(@PathVariable UUID userId) {
        return userService.findById(userId);
    }

    //find by id and update
    @PutMapping("/{userId}")
    public User findAndUpdate(@PathVariable UUID userId, @RequestBody User body) {
        return userService.findByIdAndUpdate(userId, body);
    }

    //delete
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable UUID userId) {
        userService.findByIdAndDelete(userId);
    }
}
