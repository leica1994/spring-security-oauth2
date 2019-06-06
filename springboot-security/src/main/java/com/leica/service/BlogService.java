package com.leica.service;

import com.leica.entity.Blog;

import java.util.List;

/**
 * Blog业务管理
 *
 * @author leica
 * @since 2019/6/6 17:21
 */
public interface BlogService {
    List<Blog> getBlogs();

    void deleteBlog(long id);
}
