package com.example.blog.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Getter
public class BlogResponsePWDto {
    private final boolean success;
    public BlogResponsePWDto(BlogRequestDto blogRequestDto, Blog blog){
        if(blogRequestDto.getPassword().equals(blog.getPassword())){
            this.success=true;
        }else{
            this.success=false;
        }
    }
}
