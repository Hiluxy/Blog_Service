package com.example.blog.domain;

import lombok.Getter;

@Getter
public class BlogRequestDto {
    private String username;
    private String contents;
    private String title;
    private String password;
}
