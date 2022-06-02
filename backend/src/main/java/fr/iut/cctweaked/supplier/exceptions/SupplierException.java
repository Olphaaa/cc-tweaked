package fr.iut.cctweaked.supplier.exceptions;

import fr.iut.cctweaked.errors.Error;
import org.springframework.http.HttpStatus;

public class SupplierException extends Error {
    public SupplierException(String message, HttpStatus status) {
        super(message, status);
    }

    public SupplierException(String message, HttpStatus status, Exception base) {
        super(message, status, base);
    }
}
