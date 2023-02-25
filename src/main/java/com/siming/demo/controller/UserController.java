package com.siming.demo.controller;

import com.siming.demo.request.RegisterUserRequest;
import com.siming.demo.response.Result;
import com.siming.demo.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * user table 前端控制器
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/v1/user")
@Tag(name = "user controller")
@AllArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "register a user")
    public Result register(@Valid @RequestBody RegisterUserRequest request) {
        userService.registerUser(request.getName());
        return Result.success();
    }

}
