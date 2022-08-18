package com.example.blog.controller;

import com.example.blog.domain.*;
import com.example.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {
    private final BlogRepository blogRepository;
    private final BlogService blogService; //@Bean이 new해줌

    //Post
    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) { //@RequestBody 꼭 붙이기~
        return blogService.create(requestDto);
    }

    //Get
    @GetMapping("/api/blogs")
    public List<BlogResponseDto> getBlogs() {
        return blogService.getBlogList();
    }

    //GetOne
    @GetMapping("/api/blogs/{id}")
    public Blog getOneBlog(@PathVariable Long id){
        return blogService.getOne(id);
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
        return blogService.delete(id);
    }

    //
    @PostMapping("/api/blogs/{id}")
    public BlogResponsePWDto checkPw(@PathVariable Long id,@RequestBody BlogRequestDto requestDto){
        return blogService.check(id,requestDto);
    }
}
