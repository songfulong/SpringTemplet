package com.huawei.springboot_mybatis;

import com.alibaba.fastjson.JSON;
import com.huawei.springboot_mybatis.doman.User;
import com.huawei.springboot_mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {

    @Value("${spring.redis.host:192.168.0.1}")
    private String host;

    @Autowired
    private UserMapper userMapper;
    @Test
    public void  Test()
    {
        List<User> users = userMapper.queryUserList();
        //System.out.println(JSON.toJSONString(users));
        System.out.println(users);
    }
}
