package com.siming.demo.service;

import com.siming.demo.entity.Booking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.siming.demo.request.BookingCarRequest;

/**
 * <p>
 * booking table 服务类
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
public interface IBookingService extends IService<Booking> {

    boolean bookingCar(BookingCarRequest request);
}
