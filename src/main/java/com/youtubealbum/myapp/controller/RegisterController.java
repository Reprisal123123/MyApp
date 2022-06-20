package com.youtubealbum.myapp.controller;

import com.youtubealbum.myapp.domain.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register() {

        return "registerForm";
    }

    @PostMapping("/register")
    public String register(UserDto userDto, Model m) {

        return "registerInfo";
    }
}
