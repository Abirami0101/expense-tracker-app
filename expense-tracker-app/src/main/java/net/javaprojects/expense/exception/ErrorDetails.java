package net.javaprojects.expense.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Schema(
        description = "Error Details Data Transfer Object transfer error details data from client and server"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    @Schema(
            description = "Error occurred date and time"
    )
    private LocalDateTime timestamp;
    @Schema(
            description = "Error message from Exception class"
    )
    private String message;
    @Schema(
            description = "Error details from WebRequest"
    )
    private String details;

    @Schema(
            description = "Error code"
    )
    private String errorCode;
}
