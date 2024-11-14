package org.koreait.member.validators;

public interface MobileValidator {
    default boolean checkMobile(String num) {
        /**
         * 01010001000
         * 010-1000-1000
         * 010.1000.1000
         * 010 1000 1000
         * 016 1000 1000
         *
         * 등 전화 번호는 패턴이 여러개가 가능함. 이것을 방지하려면?
         *
         * 1. 숫자로만 통일성 있게 변환
         * 2. 패턴
         */

        // 숫자가 아닌 문자는 모두 제거 -> 숫자
        num = num.replaceAll("\\D", "");

        String pattern = "^01[016]\\d{3,4}\\d{4}$";

        return num.matches(pattern);
    }
}
