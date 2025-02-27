package microservice_messaging.messaging.application.handler.handler;

import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.application.mapper.IMessageMapper;
import microservice_messaging.messaging.domain.api.IMessageServicePort;
import microservice_messaging.messaging.domain.model.MessageModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageHandlerTest {

    @Mock
    private IMessageServicePort messageServicePort;

    @Mock
    private IMessageMapper messageMapper;

    @InjectMocks
    private MessageHandler messageHandler;

    private MessageRequest request;
    private MessageModel model;
    private MessageResponse response;

    @BeforeEach
    void setUp() {
        request = new MessageRequest("Test message");
        model = new MessageModel("Test message");
        response = new MessageResponse("Test message");

        when(messageMapper.toModel(request)).thenReturn(model);
        when(messageMapper.toResponse(model)).thenReturn(response);
    }

    @Test
    void sendWhatsAppMessage_shouldCallServiceAndReturnResponse() {
        MessageResponse result = messageHandler.sendWhatsAppMessage(request);

        verify(messageMapper).toModel(request);
        verify(messageServicePort).sendWhatsAppMessage(model);
        verify(messageMapper).toResponse(model);

        assertEquals(response, result);
    }
}
