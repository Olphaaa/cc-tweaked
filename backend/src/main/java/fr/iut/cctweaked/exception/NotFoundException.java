package fr.iut.cctweaked.exception;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class NotFoundException extends Error {
    public NotFoundException(String message, HttpStatus status) {
        super(message, status);
    }

    public NotFoundException(String message, HttpStatus status, Exception base) {
        super(message, status, base);
    }
}
