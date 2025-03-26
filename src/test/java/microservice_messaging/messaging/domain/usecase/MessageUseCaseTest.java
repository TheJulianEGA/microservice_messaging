package microservice_messaging.messaging.domain.usecase;

import microservice_messaging.messaging.domain.model.MessageModel;
import microservice_messaging.messaging.domain.twilio.IWhatsAppTwilioPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MessageUseCaseTest {

    @Mock
    private IWhatsAppTwilioPort whatsAppTwilioPort;

    @InjectMocks
    private MessageUseCase messageUseCase;

    private MessageModel messageModel;

    @BeforeEach
    void setUp() {
        messageModel = new MessageModel("Test message");
    }

    @Test
    void sendWhatsAppMessage_shouldCallWhatsAppTwilioPort() {
        messageUseCase.sendWhatsAppMessage(messageModel);
        verify(whatsAppTwilioPort).sendWhatsAppMessage("Test message");
    }
}
