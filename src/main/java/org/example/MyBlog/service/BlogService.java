package org.example.MyBlog.service;

import lombok.RequiredArgsConstructor;
import org.example.MyBlog.domain.Article;
import org.example.MyBlog.dto.AddArticleRequest;
import org.example.MyBlog.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
}
