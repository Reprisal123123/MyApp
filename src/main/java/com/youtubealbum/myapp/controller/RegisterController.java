package com.youtubealbum.myapp.controller;

import com.youtubealbum.myapp.domain.UserDto;
import com.youtubealbum.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    UserService userService;

    @InitBinder
    public void convert(WebDataBinder binder) {
        // dateformat으로 변환
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
    }

    @GetMapping("/register")
    public String register() {

        return "registerForm";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult result, Model m) {

        try {
            if(!result.hasErrors()) {
                userService.registerUser(userDto);
                return "registerInfo";
            }
            throw new Exception("Register failed");
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("userDto", userDto);
            m.addAttribute("msg", "REG_ERR");
            return "registerForm";
        }

    }

    @PostMapping("/idCheck")
    @ResponseBody
    public Boolean idcheck(@RequestBody String id) throws Exception {
        if(8 <= id.length() && id.length() <= 12 && userService.selectUser(id)==null) {
            return true;
        }
        return false;
    }
}
