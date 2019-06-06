package com.leica.resource.controller;

import com.leica.resource.entity.TbContent;
import com.leica.resource.service.TbContentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 内容控制器
 *
 * @author leica
 * @since 2019/6/6 9:29
 */
@RestController
public class TbContentController {
    private final TbContentService tbContentService;

    public TbContentController(TbContentService tbContentService) {
        this.tbContentService = tbContentService;
    }

    @GetMapping("/")
    public List<TbContent> list() {
        return tbContentService.list();
    }
}
