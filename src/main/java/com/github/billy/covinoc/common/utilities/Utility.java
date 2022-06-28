package com.github.billy.covinoc.common.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class Utility {

  public static final int INTEGER_ZERO = 0;
  private static MessageSource messageSource;

  @Autowired
  private Utility(MessageSource messageSource) {
    Utility.messageSource = messageSource;
  }

  public static void throwConflictException(String message) {
    throw new ConflictException(
        messageSource.getMessage(message, null, LocaleContextHolder.getLocale()));
  }

  public static ConflictException throwException(String exception) {
    throw new ConflictException(
        messageSource
            .getMessage(exception, null,
                LocaleContextHolder.getLocale()));
  }

  public static ConflictException getConflictException(String message) {
    return new ConflictException(
        messageSource.getMessage(message, null, LocaleContextHolder.getLocale()));
  }

  public static ConflictException getConflictExceptionWithLogDetail(String message,
      String logDetail) {
    return new ConflictException(
        messageSource.getMessage(message, null, LocaleContextHolder.getLocale()), logDetail);
  }


  public static ConflictException throwException(String exception, String message, String param) {
    String stringBuilder =
        messageSource.getMessage(exception, null, LocaleContextHolder.getLocale()) +
            " " + param + " " +
            messageSource.getMessage(message, null, LocaleContextHolder.getLocale());
    throw new ConflictException(stringBuilder);
  }


  public static ConflictException getConflictException(String message, String... args) {
    return new ConflictException(
        messageSource.getMessage(message, args, LocaleContextHolder.getLocale()));
  }

  public static void throwConflictException(String message, String... args) {
    throw new ConflictException(
        messageSource.getMessage(message, args, LocaleContextHolder.getLocale()));
  }

  public static String getMessageByName(String messageName, String... args) {
    return messageSource.getMessage(messageName, args, LocaleContextHolder.getLocale());
  }
}
