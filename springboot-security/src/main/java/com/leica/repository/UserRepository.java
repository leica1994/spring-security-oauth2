package com.leica.repository;

import com.leica.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author leica
 * @since 2019/6/6 18:52
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
