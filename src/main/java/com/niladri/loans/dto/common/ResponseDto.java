package com.niladri.loans.dto.common;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Response", description = "Response details")
public class ResponseDto {
    @Schema(description = "Status code", example = "200")
    @NotNull
    public String statusCode;

    @Schema(description = "Status message", example = "Success")
    @NotNull
    public String statusMessage;
}
