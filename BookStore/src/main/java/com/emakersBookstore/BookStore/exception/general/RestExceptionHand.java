package com.emakersBookstore.BookStore.exception.general;

import com.emakersBookstore.BookStore.exception.NotFindError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHand {

    @ExceptionHandler(NotFindError.class)
    private ResponseEntity<RestErrorMessage> notFindErrorHandler(NotFindError exception) {
        RestErrorMessage error = new RestErrorMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<RestErrorMessage>> methodArgumentNotValidHandler(MethodArgumentNotValidException exception){
        List<RestErrorMessage> errorMessages = exception.getBindingResult().getFieldErrors().stream().map(fieldError ->
        new RestErrorMessage(HttpStatus.BAD_REQUEST, fieldError.getDefaultMessage())).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
    }
}
