package com.example.blog.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

//@RequiredArgsConstructor //참고: https://velog.io/@developerjun0615/Spring-RequiredArgsConstructor-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98%EC%9D%84-%EC%82%AC%EC%9A%A9%ED%95%9C-%EC%83%9D%EC%84%B1%EC%9E%90-%EC%A3%BC%EC%9E%85
//@NoArgsConstructor
@Getter
public final class BlogResponseDto {
    private final Long id;
    private final String title;
    private final String username;

    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;


    public BlogResponseDto(Blog blog){
        this.id=blog.getId();
        this.title=blog.getTitle();
        this.username=blog.getUsername();
        this.createdAt=blog.getCreatedAt();
        this.modifiedAt=blog.getModifiedAt();
    }


}
