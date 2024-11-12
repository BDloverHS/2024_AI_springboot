package org.koreait.global.libs;

import org.springframework.stereotype.Component;

// 빈의 이름을 정해줌
@Component("ut")
public class Utils { // 빈의 이름을 설정해주기 전의 이름은 utils
    public String hello(String name) {
        return String.format("%s님 반갑습니다.",name);
    }
}
