package com.xiaofu.attack.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaofu.attack.model.TUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRepository extends BaseMapper<TUser> {


    TUser login(TUser tUser);

    TUser attackLogin(TUser tUser);
}

