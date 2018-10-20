package com.learn.algos.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TreeSearchNotFoundRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TreeSearchNotFoundErrorResponse> handleException(TreeSearchNotFoundException exc) {
	TreeSearchNotFoundErrorResponse error = new TreeSearchNotFoundErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
		System.currentTimeMillis());
	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<TreeSearchNotFoundErrorResponse> handleException(Exception exc) {
	TreeSearchNotFoundErrorResponse error = new TreeSearchNotFoundErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(),
		System.currentTimeMillis());
	return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
