package federicopignatelli.U2S2L5_backend_esercitazione.exception;

import java.util.UUID;

public class NotFoundException extends RuntimeException{

    public NotFoundException(UUID id) {
        super("ID: " + id + " non presente");
    }
}
