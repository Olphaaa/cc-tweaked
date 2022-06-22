package fr.iut.cctweaked.exception;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class SiteException extends Error{
    public SiteException(String message, HttpStatus status) {
        super(message, status);
    }

    public SiteException(String message, HttpStatus status, Exception base) {
        super(message, status, base);
    }
}
