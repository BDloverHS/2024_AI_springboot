package org.koreait.member.validators;

import org.koreait.member.controllers.RequestJoin;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class JoinValidator implements Validator {
    /**
     * 검증을 할 커맨드 객체를 한정
     * RequestJoin 커맨드 객체만을 검증할 거야!
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     * being asked if it can {@link #validate(Object, Errors) validate}
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     * 커맨드 객체 검증 수행
     *
     * Object target : 검증할 커맨드 객체
     * Errors errors
     *   - 검증 실패 시 전달할 메세지를 설정
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     */
    @Override
    public void validate(Object target, Errors errors) {
        RequestJoin form = (RequestJoin)target;

        /**
         * 필수 항목 검증 S
         * email, password, confirmPassword, name, agree
         */

        String email = form.getEmail();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String name = form.getName();
        boolean agree = form.isAgree();

        if (email == null || email.isBlank()) {
            errors.rejectValue("email", "Retired", "이메일을 입력하세요.");
        }

        if (password == null || password.isBlank()) {
            errors.rejectValue("password", "Required", "비밀번호를 입력하세요.");
        }

        if (confirmPassword == null || confirmPassword.isBlank()) {
            errors.rejectValue("confirmPassword", "Required", "비밀번호 확인을 입력하세요.");
        }

        if (name == null || name.isBlank()) {
            errors.rejectValue("name", "Required", "회원명을 입력하세요.");
        }

        if (!agree) { // 약관에 동의하지 않은 경우
            errors.rejectValue("agree", "Required", "약관에 동의해주세요.");
        }

        if (password != null && confirmPassword != null && !password.equals(confirmPassword)) {
            errors.rejectValue("confirmPassword", "Required", "비밀번호가 일치하지 않습니다.");
        }

        /* 필수항목 검증 E */
    }
}
