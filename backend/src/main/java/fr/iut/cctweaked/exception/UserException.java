package fr.iut.cctweaked.exception;

import org.springframework.http.HttpStatus;
import fr.iut.cctweaked.errors.Error;


public class UserException extends Error{
    public UserException(String message, HttpStatus status) {
        super(message, status);
    }

    public UserException(String message, HttpStatus status, Exception base) {
        super(message, status, base);
    }
}
