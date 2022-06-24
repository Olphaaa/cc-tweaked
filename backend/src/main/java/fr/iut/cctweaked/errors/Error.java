package fr.iut.cctweaked.errors;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Error extends RuntimeException {
    private final String message;
    private Exception base;

    public Error(String message) {
        super(message);
        this.message = message;
    }

    public Error(String message, Exception base) {
        super(message);
        this.message = message;
        this.base = base;
    }
}
