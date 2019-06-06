package com.leica.server.repository;

import com.leica.server.entity.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TbUser数据库访问接口
 *
 * @author leica
 * @since 2019/6/6 1:07
 */
@Repository
public interface TbUserRepository extends JpaRepository<TbUser, Long> {
    TbUser findTbUserByUsername(String username);
}
