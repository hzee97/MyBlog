package org.example.MyBlog.service;

import lombok.RequiredArgsConstructor;
import org.example.MyBlog.domain.Article;
import org.example.MyBlog.dto.AddArticleRequest;
import org.example.MyBlog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor  // final or @NotNull 이 붙은 필드의 생성자 추가.
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }

    // 전체 글 조회 메서드
    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }
}
