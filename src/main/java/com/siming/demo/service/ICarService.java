package com.siming.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siming.demo.entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;
import com.siming.demo.request.RegisterCarRequest;
import com.siming.demo.request.SearchCarRequest;

/**
 * <p>
 * car information 服务类
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
public interface ICarService extends IService<Car> {

    void registerCar(RegisterCarRequest request);
    void deleteCar(Long id);

    Page<Car> searchCar(SearchCarRequest request);

}
