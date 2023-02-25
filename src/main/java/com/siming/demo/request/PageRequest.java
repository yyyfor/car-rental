package com.siming.demo.request;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Schema(title = "page request request")
public class PageRequest {

    @Min(1)
    @Max(100)
    @Parameter(name = "the page number",description = "page should between 1 and 100")
    private Integer page = 1;

    @Min(1)
    @Max(100)
    @Parameter(name = "the page size",description = "page size should between 1 and 100")
    private Integer size = 20;
}
