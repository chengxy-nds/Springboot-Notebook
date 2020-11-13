package com.xiaofu.sharding.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaofu.sharding.model.TUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserRepository extends BaseMapper<TUser> {

}

