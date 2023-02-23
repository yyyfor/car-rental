package com.siming.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * car information
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@Getter
@Setter
public class Car implements Serializable {

    /**
     * primary key id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * the brand of the car
     */
    private String brand;

    /**
     * the model of the car
     */
    private String model;

    /**
     * the price for rent car for one hour
     */
    private BigDecimal pricePerHour;

    /**
     * the create time of the car
     */
    private LocalDateTime createTime;

    /**
     * the update time of the car
     */
    private LocalDateTime updateTime;


}
