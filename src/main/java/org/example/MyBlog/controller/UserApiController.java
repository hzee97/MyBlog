package org.example.MyBlog.controller;

import lombok.RequiredArgsConstructor;
import org.example.MyBlog.dto.AddUserRequest;
import org.example.MyBlog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {
    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }
}
