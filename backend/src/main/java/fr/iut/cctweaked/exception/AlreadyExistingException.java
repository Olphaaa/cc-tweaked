package fr.iut.cctweaked.exception;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class AlreadyExistingException extends Error{

    public AlreadyExistingException(String message, HttpStatus status) {
        super(message, status);
    }

    public AlreadyExistingException(String message, HttpStatus status, Exception base) {
        super(message, status, base);
    }
}
