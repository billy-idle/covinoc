package com.github.billy.covinoc.common.utilities.error;

import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(3)
class RestResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class,
      DataIntegrityViolationException.class})
  protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
    String bodyOfResponse = "This should be application specific";
    return handleExceptionInternal(ex, bodyOfResponse + ": " + ex.getCause().getMessage(),
        new HttpHeaders(), HttpStatus.CONFLICT,
        request);
  }
}