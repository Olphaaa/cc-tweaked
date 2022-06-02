package fr.iut.cctweaked.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorBean {
    @ExceptionHandler(value = Error.class)
    public ResponseEntity<Object> exception(Error error) {
        return ResponseEntity.status(error.getStatusCode()).body(error.getMessage());
    }
}
