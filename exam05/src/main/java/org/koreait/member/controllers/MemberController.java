package org.koreait.member.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.koreait.member.validators.JoinValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;

    /*
    @GetMapping("/join")
    public String join(Model model) {

        RequestJoin requestJoin = new RequestJoin();
        model.addAttribute("requestJoin", requestJoin);

        return "member/joinForm";
    }
    */

    /*
    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form, Model model) { // RequestJoin - requestJoin

        model.addAttribute("message", "반갑습니다");
        return "member/joinForm";
    }
    */

    // 컨트롤러 내에서 전역으로 설정
    @ModelAttribute("apples")
    public List<String> apples() {
        return List.of("사과1", "사과2", "사과3");
    }

    /**
     * 회원 가입 처리
     * @return
     */
    @PostMapping("/join")
    public String joinPs(RequestJoin form, Errors errors) {
        joinValidator.validate(form, errors); // 커맨드 객체 검증

        if (errors.hasErrors()) { // 검증 실패! - reject, rejectValue가 한 번이라도 호출됨
            return "member/joinForm"; // 검증 실패하면 사용자에게 양식을 다시 보여주고, 검증 실패 정보를 제공
        }

        // 검증 성공 시 - 가입처리 서비스 호출
        return "redirect:/member/login"; // 가입 성공 시 로그인 페이지로 이동
    }
}
