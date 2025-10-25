package org.library.loan.core.exception;

public class NotFoundException extends CoreException {
    public NotFoundException(String code, String message) {
        super(code, message);
    }
}
