package microservice_messaging.messaging.infrastructure.util;

public class InfrastructureConstants {

    public static final String CLAIM_AUTHORITIES = "authorities";
    public static final int TOKEN_PREFIX_LENGTH = 7;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String NO_AUTHENTICATED_USER_ID_FOUND = "No authenticated user id found";
    public static final String ROLE_EMPLOYEE = "hasRole('EMPLOYEE')";
    public static final String AUTH_HEADER = "Authorization";

    private InfrastructureConstants() {
    }

}
