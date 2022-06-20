package com.example.test0620.service.blog;

import com.example.test0620.model.Blog;
import com.example.test0620.service.IGeneralService;

import java.time.LocalDateTime;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findTop5New();

    Iterable<Blog> findAllByTittleContaining(String name);

    Iterable<Blog> findAllByOrderByLikesAsc();


//    Iterable<Blog> findAllByOrderByLocalDateTime();
}
