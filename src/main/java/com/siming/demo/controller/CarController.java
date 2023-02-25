package com.siming.demo.controller;

import com.siming.demo.request.RegisterCarRequest;
import com.siming.demo.request.RegisterUserRequest;
import com.siming.demo.request.SearchCarRequest;
import com.siming.demo.response.Result;
import com.siming.demo.service.ICarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * car information 前端控制器
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@RestController
@RequestMapping("/v1/car")
@Tag(name = "car controller")
@AllArgsConstructor
public class CarController {

    private final ICarService carService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "register a car")
    public Result register(@Valid @RequestBody RegisterCarRequest request) {
        carService.registerCar(request);
        return Result.success();
    }

    @DeleteMapping()
    @Operation(summary = "delete a car")
    public Result delete(@Valid @NotNull @RequestParam Long id) {
        carService.deleteCar(id);
        return Result.success();
    }

    @PostMapping(value = "/search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "search car")
    public Result search(@Valid @RequestBody SearchCarRequest request) {
        var response = carService.searchCar(request);
        return Result.success(response);
    }
}
