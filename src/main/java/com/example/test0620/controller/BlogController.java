package com.example.test0620.controller;

import com.example.test0620.model.Blog;
import com.example.test0620.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/blogs")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    //    Hiện danh sách
    @GetMapping()
    public ResponseEntity<Iterable<Blog>> findAllProduct() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/sortLikes")
    public ResponseEntity<Iterable<Blog>> findAllByOrderByLikesAsc() {
        return new ResponseEntity<>(blogService.findAllByOrderByLikesAsc(), HttpStatus.OK);
    }

    //    Tìm theo tên
    @GetMapping("/search")
    public ResponseEntity<Iterable<Blog>> findByName(@RequestParam String tittle) {
        return new ResponseEntity<>(blogService.findAllByTittleContaining(tittle), HttpStatus.OK);
    }

//    @GetMapping("/searchTime")
//    public ResponseEntity<Iterable<Blog>> findByCreateAt() {
//        return new ResponseEntity<>(blogService.findAllByOrderByLocalDateTime(), HttpStatus.OK);
//    }

    //    Hiện 4 sản phẩm mới nhất
    @GetMapping("/findTop5")
    public ResponseEntity<Iterable<Blog>> findTop4New() {
        return new ResponseEntity<>(blogService.findTop5New(), HttpStatus.OK);
    }


    //    Tìm theo id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Blog>> findById(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    //    Thêm
    @PostMapping
    public ResponseEntity<Blog> createNewBlog(@RequestBody Blog blog) {
        return new ResponseEntity<>(blogService.save(blog), HttpStatus.CREATED);
    }

    //    Sửa
    @PutMapping("/{id}")
    public ResponseEntity<Blog> updateProductById(@PathVariable Long id, @RequestBody Blog blog) {
        blog.setId(id);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    //    Xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<Blog> deleteById(@PathVariable Long id) {
        Optional<Blog> idBlog = blogService.findById(id);
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

