package org.koreait.global.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        // 어차피 properties 파일만 가능하기 때문에 확장자명은 생략
        ms.addBasenames("messages.commons");
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }
}
