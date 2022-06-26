package io.mini.jejoTrip.controller;

import io.mini.jejoTrip.domain.dto.ReviewsDTO;
import io.mini.jejoTrip.domain.dto.UsersDTO;
import io.mini.jejoTrip.domain.entity.Users;
import io.mini.jejoTrip.service.ReviewService;
import io.mini.jejoTrip.service.SignupService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomeController {
    private SignupService signupService;
    private ReviewService reviewService;

    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(UsersDTO memberDto) {
        signupService.joinUser(memberDto);

        return "redirect:/user/login";
    }

    // 로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {


        return "/myinfo";
    }



    @GetMapping("/reviewregi")
    public String goregi(){
        return "/reviewregi";

    }

    @PostMapping("/regireview")
    public String regireview(ReviewsDTO reviewsDTO) {
        reviewService.regiReview(reviewsDTO);
        return "/reviewregi";
    }

}