package com.leica.repository;

import com.leica.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * blog数据访问
 *
 * @author leica
 * @since 2019/6/6 19:27
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
