package org.koreait.global.exceptions.script;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * 예외가 발생하면 alert('메세지'); -> target.. history.back()
 */
@Getter @Setter
public class AlertBackException extends org.koreait.global.exceptions.scripts.AlertException {

    private String target;

    public AlertBackException(String message, HttpStatus status, String target) {
        super(message, status);

        this.target = target;
    }

    public AlertBackException(String message, HttpStatus status) {
        this(message, status, "self");
    }
}
