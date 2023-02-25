package com.siming.demo.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Schema(title = "register car request")
@Data
public class RegisterCarRequest {

    @NotBlank
    @Parameter(name = "the brand name")
    String brand;

    @NotBlank
    @Parameter(name = "the model name")
    String model;
}
