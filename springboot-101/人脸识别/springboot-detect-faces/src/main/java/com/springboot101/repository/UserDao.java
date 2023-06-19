package com.springboot101.repository;

import com.springboot101.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 公众号：程序员小富
 * @Description:
 * @date 2021/10/29
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {

}
