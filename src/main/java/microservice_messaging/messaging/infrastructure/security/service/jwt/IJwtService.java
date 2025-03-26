package microservice_messaging.messaging.infrastructure.security.service.jwt;

public interface IJwtService {

    String extractUsername(String jwt);

    String extractRole(String jwt);

}
