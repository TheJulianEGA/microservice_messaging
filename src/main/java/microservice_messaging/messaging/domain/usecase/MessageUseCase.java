package microservice_messaging.messaging.domain.usecase;

import lombok.RequiredArgsConstructor;
import microservice_messaging.messaging.domain.api.IMessageServicePort;
import microservice_messaging.messaging.domain.model.MessageModel;
import microservice_messaging.messaging.domain.twilio.IWhatsAppTwilioPort;

@RequiredArgsConstructor
public class MessageUseCase implements IMessageServicePort {

    private final IWhatsAppTwilioPort whatsAppTwilioPort;

    @Override
    public void sendWhatsAppMessage(MessageModel messageModel) {
        String message = messageModel.getMessage();
        whatsAppTwilioPort.sendWhatsAppMessage( message);
    }
}
