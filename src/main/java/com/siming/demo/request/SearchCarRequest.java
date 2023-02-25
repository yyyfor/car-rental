package com.siming.demo.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@Schema(title = "search car request")
public class SearchCarRequest extends PageRequest {

    @Parameter(name = "the brand name")
    private String brand;
    @Parameter(name = "the model name")
    private String model;

    @NotNull
    @Parameter(name = "booking start time", required = true,
            description = "start time should larger than current time and smaller than end time")
    private LocalDateTime startTime;

    @NotNull
    @Parameter(name = "booking end time", required = true)
    private LocalDateTime endTime;
}
