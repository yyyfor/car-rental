package com.siming.demo.service.impl;

import com.siming.demo.entity.Car;
import com.siming.demo.mapper.CarMapper;
import com.siming.demo.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
