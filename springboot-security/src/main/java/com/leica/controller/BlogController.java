package com.leica.controller;

import com.leica.entity.Blog;
import com.leica.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Blog控制器
 *
 * @author leica
 * @since 2019/6/6 17:31
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Blog> blogs = blogService.getBlogs();
        model.addAttribute("blogsList", blogs);
        return "blogs/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id,Model model) {
        blogService.deleteBlog(id);
        model.addAttribute("blogsList", blogService.getBlogs());
        return "blogs/list";
    }
}
