package fr.iut.cctweaked.exception;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class AlreadyExistingException extends Error{

    public AlreadyExistingException(String message) {
        super(message);
    }

    public AlreadyExistingException(String message, Exception base) {
        super(message, base);
    }
}
