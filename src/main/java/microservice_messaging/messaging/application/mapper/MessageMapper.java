package microservice_messaging.messaging.application.mapper;

import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.domain.model.MessageModel;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper implements IMessageMapper{

    @Override
    public MessageModel toModel (MessageRequest request){
        return MessageModel.builder()
                .message(request.getMessage())
                .build();
    }

    @Override
    public MessageResponse toResponse (MessageModel model){
        return MessageResponse.builder()
                .message(model.getMessage())
                .build();
    }
}
