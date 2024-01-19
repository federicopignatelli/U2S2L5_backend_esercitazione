package federicopignatelli.U2S2L5_backend_esercitazione.payloads.user;
import jakarta.validation.constraints.*;
public record NewUserDTO(
        @NotEmpty(message = "Il nome è obbligatorio")
        @Size(min = 3, max = 30, message = "Nome deve avere minimo 3 caratteri, massimo 30")
        String name,
        @NotEmpty(message = "Il cognome è obbligatorio")
        String surname,
        @NotEmpty(message = "L'email è obbligatoria")
        @Email
        String email,
        @NotNull(message = "username obbligatorio")
        String username
) {
}
