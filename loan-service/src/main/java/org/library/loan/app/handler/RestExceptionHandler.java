package org.library.loan.app.handler;

import org.library.loan.app.response.dto.ApiResponse;
import org.library.loan.core.exception.CoreException;
import org.library.loan.core.exception.NotFoundException;
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

    @ExceptionHandler(CoreException.class)
    public ResponseEntity<ApiResponse<Object>> handleCoreException(CoreException e) {
        return ApiResponse.error(e).createResponse(HttpStatus.BAD_REQUEST);
    }
}
