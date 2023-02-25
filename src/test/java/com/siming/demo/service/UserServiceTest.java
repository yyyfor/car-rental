package com.siming.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.siming.demo.entity.User;
import com.siming.demo.mapper.UserMapper;
import com.siming.demo.response.BaseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@SpringBootTest()
@RunWith(SpringRunner.class)
@Transactional
class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    void registerUser() {
        String name = UUID.randomUUID().toString();
        userService.registerUser(name);
        var user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getName, name));
        Assertions.assertNotNull(user);
    }

    @Test
    void registerExistUser() {
        String name = UUID.randomUUID().toString();
        var user = User.builder().name(name).build();
        userMapper.insert(user);
        Assertions.assertThrowsExactly(BaseException.class, () -> userService.registerUser(name));
    }

}
