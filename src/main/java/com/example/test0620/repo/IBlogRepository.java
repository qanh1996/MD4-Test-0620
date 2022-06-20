package com.example.test0620.repo;

import com.example.test0620.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Long> {
    String FIND_TOP5_NEW = "select * from blogs order by id desc limit 5;";


    Iterable<Blog> findAllByTittleContaining (String tittle);

    Iterable<Blog> findAllByOrderByLikesAsc();

    @Query(nativeQuery = true, value = FIND_TOP5_NEW)
    Iterable<Blog> findTop5New();

//    Iterable<Blog> findAllByOrderByLocalDateTime();
}
