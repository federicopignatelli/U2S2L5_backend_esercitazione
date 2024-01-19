package federicopignatelli.U2S2L5_backend_esercitazione.payloads.errors;

import java.util.Date;

public record ErrorsPayload(
        String message,
        Date timestamp) {
    public ErrorsPayload(String message, Date timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}