package org.koreait.global.exceptions.script;

import org.springframework.http.HttpStatus;

public class AlertRedirectException extends org.koreait.global.exceptions.scripts.AlertException {
    
    private String url;
    private String target;
    
    public AlertRedirectException(String message, String url, HttpStatus status, String target) {
        super(message, status);
        this.url = url;
        this.target = target;
    }
    
    public AlertRedirectException(String message, String url, HttpStatus status) {
        this(message, url, status, "self"); // target의 기본값 self : 기준 - 현재창
    }
}
