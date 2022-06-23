package fr.iut.cctweaked.exception;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class NotFoundException extends Error {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Exception base) {
        super(message, base);
    }
}
