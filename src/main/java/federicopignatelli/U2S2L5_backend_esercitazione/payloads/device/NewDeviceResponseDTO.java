package federicopignatelli.U2S2L5_backend_esercitazione.payloads.device;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.deviceStatus;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.deviceType;

import java.util.UUID;

public record NewDeviceResponseDTO(UUID id, deviceType devicetype, deviceStatus devicestatus, User user) {
}
