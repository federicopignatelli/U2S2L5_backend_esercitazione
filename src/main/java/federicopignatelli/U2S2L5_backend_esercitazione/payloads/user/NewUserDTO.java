package federicopignatelli.U2S2L5_backend_esercitazione.payloads.user;
import jakarta.validation.constraints.*;
public record NewUserDTO(
        @NotEmpty(message = "nome obbligatorio")
        @Size(min = 5, max = 20, message = "Il nome dev'essere di almeno 5 caratteri con un massimo di 20")
        String name,
        @NotEmpty(message = "cognome obbligatorio")
        String surname,
        @NotEmpty(message = "email obbligatoria")
        @Email
        String email,
        @NotNull(message = "username obbligatorio")
        String username
) {
}
