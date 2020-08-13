package com.xiaofu.sharding.service;


import com.xiaofu.sharding.model.TUser;

import java.util.List;

public interface UserService {

    Integer addUser(TUser user);

    List<TUser> getUsers();

    TUser getUser(Long id);

    boolean deleteOne(Long id);

    boolean updateUser(TUser user);

}
