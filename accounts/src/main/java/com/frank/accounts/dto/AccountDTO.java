package com.frank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema to hold Account information"
)
public class AccountDTO {

    @Schema(description = "Mobile number of the customer", example = "1234567890")
    @NotEmpty(message = "Account Number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(description = "Account type for customer", example = "Savings")
    @NotEmpty(message = "Account Type can not be null or empty")
    private String accountType;

    @Schema(description = "Frank bank brunch address", example = "123 New York")
    @NotEmpty(message = "Branch address can not be null or empty")
    private String branchAddress;
}
