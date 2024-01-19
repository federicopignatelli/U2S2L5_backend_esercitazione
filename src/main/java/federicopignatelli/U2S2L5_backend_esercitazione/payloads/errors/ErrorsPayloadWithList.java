package federicopignatelli.U2S2L5_backend_esercitazione.payloads.errors;

import java.util.Date;
import java.util.List;

public record ErrorsPayloadWithList(
        String message,
        Date timestamp,
        List<String> errorsList
) {
}
