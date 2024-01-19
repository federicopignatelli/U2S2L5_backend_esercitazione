package federicopignatelli.U2S2L5_backend_esercitazione.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private deviceType devicetype;
    @Enumerated(EnumType.STRING)
    private deviceStatus devicestatus;
    @ManyToOne
    @JoinColumn(name = "user-id")
    private User user;
}
