package microservice_messaging.messaging.infrastructure.adapter;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import microservice_messaging.messaging.domain.twilio.IWhatsAppTwilioPort;
import org.springframework.beans.factory.annotation.Value;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WhatsAppTwilioAdapter implements IWhatsAppTwilioPort {
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.number}")
    private String fromNumber;

    @Value("${my.number}")
    private String toNumber;

    @Override
    public void sendWhatsAppMessage(String messageBody) {
        Twilio.init(accountSid, authToken);
        Message.creator(
                new PhoneNumber(toNumber),
                new PhoneNumber(fromNumber),
                messageBody
        ).create();
    }
}
