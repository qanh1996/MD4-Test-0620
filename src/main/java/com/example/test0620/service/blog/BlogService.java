package com.example.test0620.service.blog;

import com.example.test0620.model.Blog;
import com.example.test0620.repo.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Iterable<Blog> findTop5New() {
        return blogRepository.findTop5New();
    }

    @Override
    public Iterable<Blog> findAllByTittleContaining(String name) {
        return blogRepository.findAllByTittleContaining(name);
    }

    @Override
    public Iterable<Blog> findAllByOrderByLikesAsc() {
        return blogRepository.findAllByOrderByLikesAsc();
    }

//    @Override
//    public Iterable<Blog> findAllByOrderByLocalDateTime() {
//        return blogRepository.findAllByOrderByLocalDateTime();
//    }

}
