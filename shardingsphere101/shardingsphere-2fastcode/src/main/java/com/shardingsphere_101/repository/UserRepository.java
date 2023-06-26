package com.shardingsphere_101.repository;

import com.shardingsphere_101.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
