package com.siming.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.siming.demo.entity.User;
import com.siming.demo.mapper.UserMapper;
import com.siming.demo.response.BaseException;
import com.siming.demo.response.ErrorEnum;
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

    @Override
    public void registerUser(String name) {
        boolean exist = baseMapper.exists(new LambdaQueryWrapper<User>().eq(User :: getName, name));
        if(exist) {
            throw new BaseException(ErrorEnum.BAD_REQUEST, "user name already exists");
        }
        var user = User.builder().name(name).build();
        save(user);
    }
}
