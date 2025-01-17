package com.duyhk.be12.exception;

import com.duyhk.be12.dto.ResponseDTO;
import com.duyhk.be12.enums.Constants;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseDTO<Void> handleRuntimeException(RuntimeException exception){
        return ResponseDTO.<Void>builder()
                .statusCode(Constants.STATUS.NOT_FOUND)
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseDTO<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        return ResponseDTO.<Void>builder()
                .statusCode(Constants.STATUS.NOT_FOUND)
                .message(exception.getFieldError().getDefaultMessage())
                .build();
    }

}

// controller -> service -> repo
// .............. error -> RestControllerAdvice