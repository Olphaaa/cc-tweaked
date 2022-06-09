package fr.iut.cctweaked.exception;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class StorageException extends Error {
    public StorageException(String message, HttpStatus status) {
        super(message, status);
    }

    public StorageException(String message, HttpStatus status, Exception base) {
        super(message, status, base);
    }
}