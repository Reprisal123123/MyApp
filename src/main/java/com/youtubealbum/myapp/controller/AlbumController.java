package com.youtubealbum.myapp.controller;

import com.youtubealbum.myapp.domain.AlbumDto;
import com.youtubealbum.myapp.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @GetMapping("/list")
    public String list(HttpServletRequest request, Model m) {
        // 세션을 통해 로그인 여부 확인
        // 로그인 되어있지 않으면 toURL에 주소를 담아 전달
        if(!loginCheck(request))
            return "redirect:/login?toURL="+request.getRequestURL();

        // 로그인이 되어있으면, 세션을 얻어와서 아이디를 가져옴
        HttpSession session = request.getSession();
        String writer = (String)session.getAttribute("id");

        // 해당 writer가 가지고 있는 Album 목록을 가져옴
        try {
            List<AlbumDto> list = albumService.getList(writer);
            m.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // view
        return "albumList";
    }

    public boolean loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return session.getAttribute("id") != null;
    }
}
