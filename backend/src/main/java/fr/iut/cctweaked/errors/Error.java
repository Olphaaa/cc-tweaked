package fr.iut.cctweaked.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Error extends RuntimeException {
    private final HttpStatus statusCode;
    private final String message;
    private Exception base;

    public Error(String message, HttpStatus status) {
        super(message);
        this.statusCode = status;
        this.message = message;
    }

    public Error(String message, HttpStatus status, Exception base) {
        super(message);
        this.statusCode = status;
        this.message = message;
        this.base = base;
    }
}
