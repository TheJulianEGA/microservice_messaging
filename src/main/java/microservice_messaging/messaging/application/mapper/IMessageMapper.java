package microservice_messaging.messaging.application.mapper;

import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.domain.model.MessageModel;

public interface IMessageMapper {

    MessageModel toModel (MessageRequest request);

    MessageResponse toResponse (MessageModel model);


}
