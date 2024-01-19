package federicopignatelli.U2S2L5_backend_esercitazione.payloads.device;

import federicopignatelli.U2S2L5_backend_esercitazione.entities.User;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.deviceStatus;
import federicopignatelli.U2S2L5_backend_esercitazione.entities.deviceType;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record NewDeviceDTO(
        @NotEmpty(message = "tipo obbligatorio")
        deviceType devicetype,
        @NotEmpty(message = "stato obbligatorio")
        deviceStatus devicestatus,
        @NotEmpty(message = "utente obbligatorio")
        UUID id
) {
}
