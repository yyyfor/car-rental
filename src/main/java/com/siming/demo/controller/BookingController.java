package com.siming.demo.controller;

import com.siming.demo.entity.Booking;
import com.siming.demo.service.IBookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/demo/booking")
@Tag(name = "booking controller")
public class BookingController {

    private final IBookingService bookingService;

    @Operation(summary = "根据id查询电脑")
    @GetMapping("/{id}")
    public Booking findById(
            @Parameter(name = "id", required = true, description = "电脑id") @PathVariable Long id) {
        return this.bookingService.getById(id);
    }

}
