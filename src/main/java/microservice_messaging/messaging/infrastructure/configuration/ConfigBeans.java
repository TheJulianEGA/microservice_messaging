package microservice_messaging.messaging.infrastructure.configuration;

import microservice_messaging.messaging.domain.api.IMessageServicePort;
import microservice_messaging.messaging.domain.twilio.IWhatsAppTwilioPort;
import microservice_messaging.messaging.domain.usecase.MessageUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public IMessageServicePort messageServicePort(IWhatsAppTwilioPort whatsAppTwilioPort){
        return new MessageUseCase(whatsAppTwilioPort);
    }
}
