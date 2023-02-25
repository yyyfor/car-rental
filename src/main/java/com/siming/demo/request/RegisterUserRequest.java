package com.siming.demo.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Schema(title = "register user request")
public class RegisterUserRequest {

    @Parameter(name = "user name", required = true)
    @NotBlank
    private String name;
}
