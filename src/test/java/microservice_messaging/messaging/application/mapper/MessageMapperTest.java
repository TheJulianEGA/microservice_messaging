package microservice_messaging.messaging.application.mapper;

import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.domain.model.MessageModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageMapperTest {
    private MessageMapper messageMapper;

    @BeforeEach
    void setUp() {
        messageMapper = new MessageMapper();
    }

    @Test
    void toModel_ShouldMapRequestToModel() {

        MessageRequest request = new MessageRequest();
        request.setMessage("Hello World");

        MessageModel result = messageMapper.toModel(request);

        assertNotNull(result);
        assertEquals("Hello World", result.getMessage());
    }

    @Test
    void toResponse_ShouldMapModelToResponse() {

        MessageModel model = MessageModel.builder()
                .message("Test Message")
                .build();

        MessageResponse result = messageMapper.toResponse(model);

        assertNotNull(result);
        assertEquals("Test Message", result.getMessage());
    }
}