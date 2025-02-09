package com.kuki.tic_tac_toe_be.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(GameException.class)
     public ResponseEntity<ErrorResponse> handleGameException(GameException ex) {
          ErrorResponse error = new ErrorResponse(ex.getMessage());
          return ResponseEntity.badRequest().body(error);
     }

     @Data
     @AllArgsConstructor
     static class ErrorResponse {
          private String message;
     }
}
