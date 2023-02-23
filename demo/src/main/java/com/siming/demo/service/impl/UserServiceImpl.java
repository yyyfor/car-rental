package com.siming.demo.service.impl;

import com.siming.demo.entity.User;
import com.siming.demo.mapper.UserMapper;
import com.siming.demo.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user table 服务实现类
 * </p>
 *
 * @author siming
 * @since 2023-02-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
