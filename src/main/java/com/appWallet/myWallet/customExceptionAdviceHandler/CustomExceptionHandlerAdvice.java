package com.appWallet.myWallet.customExceptionAdviceHandler;

import com.appWallet.myWallet.customException.AppError;
import com.appWallet.myWallet.customException.CustomExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = CustomExceptionHandler.class)
public class CustomExceptionHandlerAdvice {

    @ExceptionHandler
    public ResponseEntity<AppError> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(
                new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
