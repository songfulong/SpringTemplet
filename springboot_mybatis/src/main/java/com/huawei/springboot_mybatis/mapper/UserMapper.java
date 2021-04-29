package com.huawei.springboot_mybatis.mapper;

import com.huawei.springboot_mybatis.doman.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
@Mapper
@Repository
public interface UserMapper {
    public List<User> queryUserList();

}
