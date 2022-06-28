package com.github.billy.covinoc.common.utilities.error;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
@Order(3)
class DataErrorHandling {

  public static final Pattern DATA_INTEGRITY_VIOLATION_NAME_PATTERN = Pattern.compile("[\\w\\s]+:");
  public static final Pattern DATA_INTEGRITY_VIOLATION_MESSAGE_PATTERN = Pattern.compile(
      "[A-Z]+\\([A-Z]+\\)");
  private final MessageSource messageSource;

  public DataErrorHandling(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  ErrorResponse handleDataIntegrityViolation(HttpServletRequest request,
      DataIntegrityViolationException e) {

    ErrorResponse error = new ErrorResponse();

    error.getErrors().add(new java.lang.Error(this.dataIntegrityViolationMessageTranslator(e), e));

    return error;
  }

  private String dataIntegrityViolationMessageTranslator(DataIntegrityViolationException e) {
    String specificCauseMessage = e.getMostSpecificCause().getMessage();
    Matcher matcher = DATA_INTEGRITY_VIOLATION_MESSAGE_PATTERN.matcher(specificCauseMessage);

    if (matcher.find()) {
      return this.formatMessage(StringUtils.capitalize(
          matcher.group().replace("(", ".").replace(")", "").toLowerCase()));
    }

    return specificCauseMessage;
  }

  private String formatMessage(String message) {
    return messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
  }

  private String dataIntegrityViolationNameTranslator(DataIntegrityViolationException e) {
    String specificCauseMessage = e.getMostSpecificCause().getMessage();
    Matcher nameMatcher = DATA_INTEGRITY_VIOLATION_NAME_PATTERN.matcher(specificCauseMessage);

    if (nameMatcher.find()) {
      return nameMatcher.group().replace(":", "");
    }

    return specificCauseMessage;
  }
}
