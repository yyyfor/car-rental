package com.siming.demo.mapper;

import com.siming.demo.entity.Booking;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 * booking table Mapper 接口
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
public interface BookingMapper extends BaseMapper<Booking> {

    Integer findIntervalBooking(@Param("carId") Long carId,
                                @Param("startTime") LocalDateTime startTime,
                                @Param("endTime") LocalDateTime endTime);
}
