package microservice_messaging.messaging.application.handler.handler;

import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;

public interface IMessageHandler {

    MessageResponse sendWhatsAppMessage(MessageRequest request);
}
