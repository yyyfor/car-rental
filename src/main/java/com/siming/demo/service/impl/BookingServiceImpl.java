package com.siming.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.siming.demo.entity.Booking;
import com.siming.demo.mapper.BookingMapper;
import com.siming.demo.request.BookingCarRequest;
import com.siming.demo.response.BaseException;
import com.siming.demo.response.ErrorEnum;
import com.siming.demo.service.IBookingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * booking table 服务实现类
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@Service
public class BookingServiceImpl extends ServiceImpl<BookingMapper, Booking> implements IBookingService {

    @Override
    public boolean bookingCar(BookingCarRequest request) {
        //validate time
        validateTime(request);
        //double check if the car has been booked
        int bookingNumber = baseMapper.findIntervalBooking(request.getCarId(), request.getStartTime(), request.getEndTime());
        if(bookingNumber >= 1) {
            throw new BaseException(ErrorEnum.BAD_REQUEST, "sorry this car has been booked");
        }
        var booking = Booking.builder().carId(request.getCarId()).userId(request.getUserId())
                .startTime(request.getStartTime()).endTime(request.getEndTime()).build();
        return save(booking);
    }

    private void validateTime(BookingCarRequest request) {
        if(request.getStartTime().isBefore(LocalDateTime.now()) || request.getEndTime().isBefore(LocalDateTime.now())) {
            throw new BaseException(ErrorEnum.BAD_REQUEST, "start time or end time cannot smaller than current time");
        }
        if(request.getStartTime().isAfter(request.getEndTime())) {
            throw new BaseException(ErrorEnum.BAD_REQUEST, "start time cannot larger than end time");
        }
    }
}
