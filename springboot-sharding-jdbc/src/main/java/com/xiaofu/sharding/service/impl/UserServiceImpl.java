package com.xiaofu.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaofu.sharding.mapper.UserRepository;
import com.xiaofu.sharding.model.TUser;
import com.xiaofu.sharding.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public Integer addUser(TUser user) {
        return userRepository.insert(user);
    }

    @Override
    public List<TUser> getUsers() {
        return userRepository.selectList(new QueryWrapper<>());
    }

    @Override
    public TUser getUser(Long id) {
        return null;
    }

    @Override
    public boolean deleteOne(Long id) {
        int i = userRepository.deleteById(id);
        return i > 0;
    }

    @Override
    public boolean updateUser(TUser user) {
        return userRepository.updateById(user) > 0;
    }
}
