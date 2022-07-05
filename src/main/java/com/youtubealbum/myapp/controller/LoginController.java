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
        // 1. ������ ����
        session.invalidate();
        // 2. Ȩ���� �̵�
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String pwd, String toURL, boolean rememberId,
                        HttpServletRequest request, HttpServletResponse response) {

        // 1. ���̵� ��� ��ġ Ȯ��
        if(!loginCheck(id, pwd)) {
            // 2-1 ��ġ���� ������, loginForm���� �̵�
            String msg = null;
            try {
                msg = URLEncoder.encode("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.", "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return "redirect:/login?msg=" + msg;
        }
        // 2-2. ���̵� ����� ��ġ�ϸ�,
        // ���� ��ü�� request���� ������
        HttpSession session = request.getSession();
        // ���� ��ü�� id�� ����
        session.setAttribute("id", id);

        // ���̵� ���忡 üũ�� �Ǿ�������
        if(rememberId) {
            // ��Ű�� ����
            Cookie cookie = new Cookie("id", id);
            // ���信 ����
            response.addCookie(cookie);
        } else {
            // ��Ű�� ����
            Cookie cookie = new Cookie("id", id);
            cookie.setMaxAge(0);
            // ���信 ����
            response.addCookie(cookie);
        }

        // toURL�� ������ �ش� URL�� redirect �Ѵ�.
        toURL = (toURL == null || toURL.equals("") ? "/" : toURL);
        return "redirect:" + toURL;
    }

    // �α��� ���̵�, ��й�ȣ�� DB�� ��ġ�ϴ��� üũ�ϴ� �޼���
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
