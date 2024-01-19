package federicopignatelli.U2S2L5_backend_esercitazione.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;
    private String email;
    private String username;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user-id")
    @JsonIgnore
    private List<Device> devices;
}
