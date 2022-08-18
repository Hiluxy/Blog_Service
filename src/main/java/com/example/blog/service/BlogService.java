package com.example.blog.service;

import com.example.blog.domain.Blog;
import com.example.blog.domain.BlogRepository;
import com.example.blog.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //생성자
@Service //서비스
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional //DB반영
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        blog.update(requestDto);
        return blog.getId();
    }
}
