package org.example.MyBlog.controller;

import lombok.RequiredArgsConstructor;
import org.example.MyBlog.domain.Article;
import org.example.MyBlog.dto.AddArticleRequest;
import org.example.MyBlog.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController  // HTTP Response Body 에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러.
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")   // HTTP 메서드 : POST
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }
}
