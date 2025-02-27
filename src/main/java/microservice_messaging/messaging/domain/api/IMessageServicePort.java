package microservice_messaging.messaging.domain.api;

import microservice_messaging.messaging.domain.model.MessageModel;

public interface IMessageServicePort {

    void sendWhatsAppMessage(MessageModel messageModel);

}
