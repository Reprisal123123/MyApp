package com.youtubealbum.myapp.controller;

import com.youtubealbum.myapp.domain.GlobalValidator;
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

    // 데이터 변환, Validator 등록
    @InitBinder
    public void convert(WebDataBinder binder) {
        // dateformat으로 변환
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df,false));
        binder.setValidator(new GlobalValidator());
    }

    // 회원가입 양식을 보여줌
    @GetMapping("/register")
    public String register() {

        return "registerForm";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult result, Model m) {
        // 1. 검증에 에러가 없으면 DB에 회원정보 저장하고 회원가입 완료 알려줌
       try {
            if(!result.hasErrors()) {
                userService.registerUser(userDto);
                return "registerInfo";
            }
       // 2. 에러가 있으면 예외를 던짐
            throw new Exception("Register failed");
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("userDto", userDto);
            m.addAttribute("msg", "REG_ERR");
            return "registerForm";
        }

    }

    @GetMapping("/idCheck")
    @ResponseBody
    public Boolean idcheck(String id) throws Exception {
        if(8 <= id.length() && id.length() <= 12 && userService.selectUser(id)==null) {
            return true;
        }
        return false;
    }
}
