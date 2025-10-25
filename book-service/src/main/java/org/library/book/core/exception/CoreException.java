package org.library.book.core.exception;

import lombok.Getter;

@Getter
public class CoreException extends RuntimeException {
    private final String code;

    public CoreException(String code, String message) {
        super(message);
        this.code = code;
    }
}
