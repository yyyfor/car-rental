package com.siming.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * booking table
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@Data
@Builder
public class Booking {

    /**
     * primary key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * the user id
     */
    private Long userId;

    /**
     * the car id
     */
    private Long carId;

    /**
     * the start time of the order
     */
    private LocalDateTime startTime;

    /**
     * the end time of the order
     */
    private LocalDateTime endTime;

    /**
     * the create time of the order
     */
    private LocalDateTime createTime;

    /**
     * update time of the order
     */
    private LocalDateTime updateTime;
}
