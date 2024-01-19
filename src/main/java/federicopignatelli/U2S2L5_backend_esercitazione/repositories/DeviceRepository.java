package federicopignatelli.U2S2L5_backend_esercitazione.repositories;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
