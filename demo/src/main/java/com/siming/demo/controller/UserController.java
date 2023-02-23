package com.siming.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * user table 前端控制器
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/demo/user")
@Tag(name = "user controller")
public class UserController {

}
