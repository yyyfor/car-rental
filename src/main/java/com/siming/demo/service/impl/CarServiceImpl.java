package com.siming.demo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siming.demo.constant.CarStatusEnum;
import com.siming.demo.entity.Car;
import com.siming.demo.mapper.CarMapper;
import com.siming.demo.request.RegisterCarRequest;
import com.siming.demo.request.SearchCarRequest;
import com.siming.demo.response.BaseException;
import com.siming.demo.response.ErrorEnum;
import com.siming.demo.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * car information 服务实现类
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    @Override
    public void registerCar(RegisterCarRequest request) {
        var car = Car.builder().brand(request.getBrand())
                .model(request.getModel())
                .status(CarStatusEnum.IN_USE.getStatus()).build();
        save(car);
    }

    @Override
    public void deleteCar(Long id) {
        var car = Car.builder().id(id).status(CarStatusEnum.DELETED.getStatus()).build();
        updateById(car);
    }

    @Override
    public Page<Car> searchCar(SearchCarRequest request) {
        validateTime(request);
        IPage<Car> page = Page.of(request.getPage(), request.getSize());
        return baseMapper.searchCar(page, request.getStartTime(), request.getEndTime(), request.getBrand(), request.getModel(), CarStatusEnum.IN_USE.getStatus());
    }

    private void validateTime(SearchCarRequest request) {
        if(request.getStartTime().isBefore(LocalDateTime.now()) || request.getEndTime().isBefore(LocalDateTime.now())) {
            throw new BaseException(ErrorEnum.BAD_REQUEST, "start time or end time cannot smaller than current time");
        }
        if(request.getStartTime().isAfter(request.getEndTime())) {
            throw new BaseException(ErrorEnum.BAD_REQUEST, "start time cannot larger than end time");
        }
    }
}
