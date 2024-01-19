package federicopignatelli.U2S2L5_backend_esercitazione.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
