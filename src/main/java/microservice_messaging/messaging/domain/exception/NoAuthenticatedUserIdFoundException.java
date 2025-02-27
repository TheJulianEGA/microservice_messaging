package microservice_messaging.messaging.domain.exception;

public class NoAuthenticatedUserIdFoundException extends RuntimeException {
    public NoAuthenticatedUserIdFoundException(String message) {
        super(message);
    }
}
