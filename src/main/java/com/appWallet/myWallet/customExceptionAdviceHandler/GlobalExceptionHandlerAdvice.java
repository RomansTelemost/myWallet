package com.appWallet.myWallet.customExceptionAdviceHandler;

import com.appWallet.myWallet.customException.AppError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice()
public class GlobalExceptionHandlerAdvice {

//    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(Exception e) {
        return new ResponseEntity<>(
                new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}
