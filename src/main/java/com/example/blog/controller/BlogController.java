package com.example.blog.controller;

import com.example.blog.domain.Blog;
import com.example.blog.domain.BlogRepository;
import com.example.blog.domain.BlogRequestDto;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService;

    //Post
    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) { //@RequestBody 꼭 붙이기~
        Blog blog = new Blog(requestDto);
        return blogRepository.save(blog);
    }

    //Get
    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAllByOrderByModifiedAtDesc();
    }

    //Put
    @PutMapping("/api/blogs/{id}")
    public Long updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto) {
        blogService.update(id, requestDto);
        return id;
    }

    //Delete
    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }
}
