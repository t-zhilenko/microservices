package com.frank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Schema(
        name = "Response",
        description = "Schema to hold succesful response information"
)
@Data
@AllArgsConstructor
public class ResponseDTO {

    @Schema(description = "Response status code")
    private String statusCode;

    @Schema(description = "Response message")
    private String statusMsg;
}
