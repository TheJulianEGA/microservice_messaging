package microservice_messaging.messaging.application.handler.handler;

import lombok.RequiredArgsConstructor;
import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.application.mapper.IMessageMapper;
import microservice_messaging.messaging.domain.api.IMessageServicePort;
import microservice_messaging.messaging.domain.model.MessageModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageHandler implements IMessageHandler {

    private final IMessageServicePort messageServicePort;
    private final IMessageMapper messageMapper;

    @Override
    public MessageResponse sendWhatsAppMessage(MessageRequest request) {

        MessageModel model = messageMapper.toModel(request);

        messageServicePort.sendWhatsAppMessage(model);

        return messageMapper.toResponse(model);
    }
}