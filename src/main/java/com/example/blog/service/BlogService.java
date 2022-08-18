package com.example.blog.service;

import com.example.blog.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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

    public Blog create(BlogRequestDto blogRequestDto){
        Blog blog = new Blog(blogRequestDto);
        return blogRepository.save(blog);
    };

    public Long delete(Long id){
        blogRepository.deleteById(id);
        return id;
    }

    public Blog getOne(Long id){
        return blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    public List<BlogResponseDto> getBlogList(){
        List<Blog> BlogList=blogRepository.findAllByOrderByModifiedAtDesc();
        List<BlogResponseDto> responseMainDtoList =new ArrayList<>();
        for(int i=0;i<BlogList.size();i++)
        {
            Blog assignment = BlogList.get(i);
            BlogResponseDto responseMainDto = new BlogResponseDto(assignment);
            responseMainDtoList.add(responseMainDto);
        }
        return responseMainDtoList;
    }

    public BlogResponsePWDto check(Long id, BlogRequestDto requestDto){
         Blog blog=blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
         BlogResponsePWDto blogResponsePWDto=new BlogResponsePWDto(requestDto,blog);
         return blogResponsePWDto;
    }

}
