package com.example.blog.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByModifiedAtDesc(); //Orderby을 modifiedAt순으로 Desc정렬 ->최신순정렬

}

