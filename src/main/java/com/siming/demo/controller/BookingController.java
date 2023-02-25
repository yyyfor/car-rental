package com.siming.demo.controller;

import com.siming.demo.entity.Booking;
import com.siming.demo.request.BookingCarRequest;
import com.siming.demo.response.Result;
import com.siming.demo.service.IBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * booking table 前端控制器
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/booking")
@Tag(name = "booking controller")
public class BookingController {

    private final IBookingService bookingService;

    @Operation(summary = "booking car")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result bookingCar(@Valid @RequestBody BookingCarRequest request) {
        var success = bookingService.bookingCar(request);
        return Result.result(success);
    }

}
