package federicopignatelli.U2S2L5_backend_esercitazione.payloads.user;

import java.util.UUID;

public record NewUserResponseDTO(UUID id, String name, String surname, String email, String username) {
}
