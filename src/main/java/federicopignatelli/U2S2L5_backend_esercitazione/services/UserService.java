package federicopignatelli.U2S2L5_backend_esercitazione.services;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.exception.NotFoundException;
import federicopignatelli.U2S2L5_backend_esercitazione.payloads.user.NewUserDTO;
import federicopignatelli.U2S2L5_backend_esercitazione.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(NewUserDTO body) {
        User newUser = new User();
        newUser.setName(body.name());
        newUser.setSurname(body.surname());
        newUser.setEmail(body.email());
        newUser.setUsername(body.username());

        return userRepository.save(newUser);
    }

    public Page<User> getUser(int page, int size, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sort));
        return userRepository.findAll(pageable);
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public User findByIdAndUpdate(UUID id, User body) {
        User found = this.findById(id);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setUsername(body.getUsername());

        return userRepository.save(found);
    }

    public void findByIdAndDelete(UUID id) {
        User found = this.findById(id);
        userRepository.delete(found);
    }
}
