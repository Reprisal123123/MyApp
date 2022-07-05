package com.youtubealbum.myapp.controller;

import com.youtubealbum.myapp.domain.UserDto;
import com.youtubealbum.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login() {

        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // 1. 세션을 종료
        session.invalidate();
        // 2. 홈으로 이동
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) {

        // 1. 아이디 비번 일치 확인
        if(!loginCheck(id, pwd)) {
            // 2-1 일치하지 않으면, loginForm으로 이동
            String msg = null;
            try {
                msg = URLEncoder.encode("아이디 또는 비밀번호가 일치하지 않습니다.", "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return "redirect:/login?msg=" + msg;
        }
        // 2-2. 아이디 비번이 일치하면,
        // 세션 객체를 request에서 얻어오기
        HttpSession session = request.getSession();
        // 세션 객체에 id를 저장
        session.setAttribute("id", id);

        // 아이디 저장에 체크가 되어있으면
        if(rememberId) {
            // 쿠키를 생성
            Cookie cookie = new Cookie("id", id);
            // 응답에 저장
            response.addCookie(cookie);
        } else {
            // 쿠키를 삭제
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            // 응답에 저장
            response.addCookie(cookie);
        }

        // toURL이 있으면 해당 URL로 redirect 한다.
        toURL = (toURL == null || toURL.equals("") ? "/" : toURL);
        return "redirect:" + toURL;
    }

    // 로그인 아이디, 비밀번호가 DB와 일치하는지 체크하는 메서드
    private boolean loginCheck(String id, String pwd) {
        UserDto userDto = null;

        try {
            userDto = userService.selectUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return userDto!=null && userDto.getPwd().equals(pwd);
    }
}
