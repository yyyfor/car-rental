package com.siming.demo.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.siming.demo.entity.Car;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * <p>
 * car information Mapper 接口
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
public interface CarMapper extends BaseMapper<Car> {

    Page<Car> searchCar(IPage<Car> page,
                        @Param("startTime") LocalDateTime startTime,
                        @Param("endTime") LocalDateTime endTime,
                        @Param("brand") String brand,
                        @Param("model") String model,
                        @Param("status") Integer status);
}
