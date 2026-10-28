package com.prac26102026.prac1.exceptionHandler;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InternalServerException  extends RuntimeException {
    private String errorCode;
    public InternalServerException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InternalServerException(String message){
        super(message);
        this.errorCode = "500";
    }
}