package com.github.billy.covinoc.common.utilities.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Slf4j
@ControllerAdvice
@Order(1)
class ViolationHandling {

  private final MessageSource messageSource;

  public ViolationHandling(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  ValidationErrorResponse onConstraintValidationException(ConstraintViolationException e) {
    ValidationErrorResponse error = new ValidationErrorResponse();

    for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
      error.getViolations().add(
          new Violation(violation.getPropertyPath().toString(),
              this.formatMessage(violation.getMessage())));
    }

    return error;
  }

  private String formatMessage(String message) {
    return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  ValidationErrorResponse onMethodArgumentNotValidException(MethodArgumentNotValidException e) {
    ValidationErrorResponse error = new ValidationErrorResponse();

    for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
      error.getViolations()
          .add(new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
    }

    return error;
  }
}