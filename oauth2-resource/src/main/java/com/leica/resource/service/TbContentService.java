package com.leica.resource.service;

import com.leica.resource.entity.TbContent;
import com.leica.resource.repository.TbContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TbContent业务管理
 *
 * @author leica
 * @since 2019/6/6 9:38
 */
@Service
public class TbContentService {
    private final TbContentRepository tbContentRepository;

    public TbContentService(TbContentRepository tbContentRepository) {
        this.tbContentRepository = tbContentRepository;
    }

    public List<TbContent> list() {
        return tbContentRepository.findAll();
    }
}
