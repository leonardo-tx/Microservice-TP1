package org.library.book.app.handler;

import org.library.book.app.response.dto.ApiResponse;
import org.library.book.core.exception.ConflictException;
import org.library.book.core.exception.CoreException;
import org.library.book.core.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFoundException(NotFoundException e) {
        return ApiResponse.error(e).createResponse(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiResponse<Object>> handleConflictException(ConflictException e) {
        return ApiResponse.error(e).createResponse(HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ApiResponse<Object>> handleCoreException(CoreException e) {
        return ApiResponse.error(e).createResponse(HttpStatus.BAD_REQUEST);
    }
}
