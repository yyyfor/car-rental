package com.siming.demo.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Rental Car Booking")
                        .description("Rental Car Booking Service API")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://github.com/yyyfor/car-rental")));
    }

}
