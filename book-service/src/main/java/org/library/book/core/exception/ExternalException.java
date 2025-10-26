package org.library.book.core.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExternalException extends CoreException {
    private final HttpStatus status;

    public ExternalException(String code, String message, HttpStatus status) {
        super(code, message);
        this.status = status;
    }
}
