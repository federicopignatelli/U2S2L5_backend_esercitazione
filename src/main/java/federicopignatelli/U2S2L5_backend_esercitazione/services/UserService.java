package federicopignatelli.U2S2L5_backend_esercitazione.services;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(NewUserDTO body) {
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setSurname(body.surname());
        newUser.setEmail(body.email());
        newUser.setUsername(body.email());

        return userRepository.save(newUser);
    }
}
