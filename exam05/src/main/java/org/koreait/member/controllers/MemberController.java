package org.koreait.member.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/join")
    public String join() {

        return "member/joinForm";
    }

    /**
     * 회원 가입 처리
     * @return
     */
    @PostMapping("/join")
    public String joinPs(RequestJoin form) {
        // 정보
        log.info(form.toString());



        return "member/joinForm"; // 임시
    }
}