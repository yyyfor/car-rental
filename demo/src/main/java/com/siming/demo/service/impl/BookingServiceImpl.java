package com.siming.demo.service.impl;

import com.siming.demo.entity.Booking;
import com.siming.demo.mapper.BookingMapper;
import com.siming.demo.service.IBookingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
