package microservice_messaging.messaging.infrastructure.http.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.application.handler.handler.IMessageHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageControllerTest {

    @InjectMocks
    private MessageController messageController;

    @Mock
    private IMessageHandler messageHandler;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    private MessageRequest messageRequest;
    private MessageResponse messageResponse;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(messageController).build();

        messageRequest = new MessageRequest();
        messageResponse = new MessageResponse();
    }

    @Test
    void sendWhatsAppMessage_ShouldReturnOk_WhenRequestIsValid() throws Exception {
        when(messageHandler.sendWhatsAppMessage(any(MessageRequest.class))).thenReturn(messageResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/whatsapp/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(messageRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(messageResponse)));

        verify(messageHandler, times(1)).sendWhatsAppMessage(any(MessageRequest.class));
    }
}