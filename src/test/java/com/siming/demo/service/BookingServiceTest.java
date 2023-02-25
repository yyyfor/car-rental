package com.siming.demo.service;

import com.siming.demo.constant.CarStatusEnum;
import com.siming.demo.entity.Booking;
import com.siming.demo.entity.Car;
import com.siming.demo.mapper.CarMapper;
import com.siming.demo.request.BookingCarRequest;
import com.siming.demo.response.BaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest()
@RunWith(SpringRunner.class)
@Transactional
class BookingServiceTest {

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private CarMapper carMapper;

    @Test
    void bookingCar() {
        var car = Car.builder().model("test").brand("test").id(1000L).status(CarStatusEnum.IN_USE.getStatus()).build();
        carMapper.insert(car);
        LocalDateTime now = LocalDateTime.now();
        var request = BookingCarRequest.builder().carId(1000L).userId(1L)
                .startTime(now.plusHours(1)).endTime(now.plusHours(2)).build();
        var bookSuccess = bookingService.bookingCar(request);
        Assertions.assertTrue(bookSuccess);
    }

    @Test
    void bookingCarSuccess() {
        LocalDateTime now = LocalDateTime.now();
        var car = Car.builder().model("test").brand("test").id(1000L).status(CarStatusEnum.IN_USE.getStatus()).build();
        carMapper.insert(car);
        var booking = Booking.builder().userId(1L).carId(1000L).startTime(now.minusHours(3))
                .endTime(now.minusHours(1)).build();
        bookingService.save(booking);
        var request = BookingCarRequest.builder().carId(1000L).userId(1L)
                .startTime(now.plusHours(1)).endTime(now.plusHours(2)).build();
        var bookSuccess = bookingService.bookingCar(request);
        Assertions.assertTrue(bookSuccess);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 10, 4, 11",
            "3, 10, 4, 9",
            "3, 10, 2, 5",
    })
    void bookingCarFail(int val1, int val2, int val3, int val4) {
        LocalDateTime now = LocalDateTime.now();
        var car = Car.builder().model("test").brand("test").id(1000L).status(CarStatusEnum.IN_USE.getStatus()).build();
        carMapper.insert(car);
        var booking = Booking.builder().userId(1L).carId(1000L).startTime(now.plusHours(val1))
                .endTime(now.plusHours(val2)).build();
        bookingService.save(booking);
        var request = BookingCarRequest.builder().carId(1000L).userId(1L)
                .startTime(now.plusHours(val3)).endTime(now.plusHours(val4)).build();
        Assertions.assertThrowsExactly(BaseException.class, () -> bookingService.bookingCar(request));
    }



}
