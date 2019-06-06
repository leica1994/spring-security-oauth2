package com.leica.resource.repository;

import com.leica.resource.entity.TbContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TbContent数据访问
 *
 * @author leica
 * @since 2019/6/6 9:37
 */
@Repository
public interface TbContentRepository extends JpaRepository<TbContent,Long> {
}
