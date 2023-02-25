package com.siming.demo.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Schema(title = "booking car request")
public class BookingCarRequest {

    @Parameter(name = "car id", required = true)
    @NotNull
    Long carId;

    @Parameter(name = "user id", required = true,
    description = "in real project we retrieve user id from token")
    @NotNull
    Long userId;

    @NotNull
    @Parameter(name = "booking start time", required = true,
    description = "start time should larger than current time and smaller than end time")
    LocalDateTime startTime;

    @NotNull
    @Parameter(name = "booking end time", required = true)
    LocalDateTime endTime;
}
