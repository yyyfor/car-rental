package com.siming.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siming.demo.constant.CarStatusEnum;
import com.siming.demo.entity.Car;
import com.siming.demo.mapper.CarMapper;
import com.siming.demo.request.RegisterCarRequest;
import com.siming.demo.request.SearchCarRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest()
@RunWith(SpringRunner.class)
@Transactional
class CarServiceTest {

    @Autowired
    private ICarService carService;

    @Autowired
    private CarMapper carMapper;

    @Test
    void bookingCar() {
        var request = RegisterCarRequest.builder().model("test").brand("test").build();
        carService.registerCar(request);
        var car = carMapper.selectOne(new LambdaQueryWrapper<Car>().eq(Car :: getBrand, "test")
                .eq(Car :: getModel, "test"));
        Assertions.assertNotNull(car);
        Assertions.assertEquals(car.getStatus(), CarStatusEnum.IN_USE.getStatus());
    }

    @Test
    void deleteCar() {
        var car = Car.builder().model("test").brand("test").build();
        carMapper.insert(car);
        carService.deleteCar(car.getId());
        car = carMapper.selectById(car.getId());
        Assertions.assertEquals(CarStatusEnum.DELETED.getStatus(), car.getStatus());
    }

    @Test
    void searchCar() {
        var car = Car.builder().model("test").brand("test").build();
        var car2 = Car.builder().model("test1").brand("test1").build();
        carMapper.insert(car);
        carMapper.insert(car2);
        LocalDateTime now = LocalDateTime.now();
        var request = SearchCarRequest.builder().startTime(now.plusHours(1))
                        .endTime(now.plusHours(2)).build();
        Page<Car> cars = carService.searchCar(request);
        Assertions.assertTrue(cars.getTotal() >= 2);
    }

    @Test
    void searchCar2() {
        var car = Car.builder().model("test").brand("test").build();
        var car2 = Car.builder().model("test1").brand("test1").build();
        carMapper.insert(car);
        carMapper.insert(car2);
        LocalDateTime now = LocalDateTime.now();
        var request = SearchCarRequest.builder().startTime(now.plusHours(1))
                .endTime(now.plusHours(2)).brand("test").build();
        Page<Car> cars = carService.searchCar(request);
        Assertions.assertEquals(1, cars.getTotal());
    }




}
