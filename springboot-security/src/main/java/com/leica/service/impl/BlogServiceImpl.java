package com.leica.service.impl;

import com.leica.entity.Blog;
import com.leica.repository.BlogRepository;
import com.leica.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Blog业务管理实现
 *
 * @author leica
 * @since 2019/6/6 17:24
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBlog(long id) {
        blogRepository.deleteById(id);
    }
}
