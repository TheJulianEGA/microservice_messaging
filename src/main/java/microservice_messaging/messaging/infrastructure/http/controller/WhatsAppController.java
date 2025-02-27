package microservice_messaging.messaging.infrastructure.http.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import microservice_messaging.messaging.application.dto.MessageRequest;
import microservice_messaging.messaging.application.dto.MessageResponse;
import microservice_messaging.messaging.application.handler.handler.IMessageHandler;
import microservice_messaging.messaging.infrastructure.util.InfrastructureConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/whatsapp")
@RequiredArgsConstructor
public class WhatsAppController {

    private final IMessageHandler messageHandler;

    @Operation(
            summary = "Send a WhatsApp message",
            description = "Allows an employee to send a WhatsApp message. Requires employee role."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Message sent successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "403", description = "Access denied - only employees can send messages",
                    content = @Content(mediaType = "application/json"))
    })
    @PreAuthorize(InfrastructureConstants.ROLE_EMPLOYEE)
    @PostMapping("/send")
    public ResponseEntity<MessageResponse> sendWhatsAppMessage(@RequestBody MessageRequest request) {
        MessageResponse response = messageHandler.sendWhatsAppMessage(request);
        return ResponseEntity.ok(response);
    }
}
