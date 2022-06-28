package com.github.billy.covinoc.common.mapper;

import com.github.billy.covinoc.common.domain.type.PhoneNumber;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneNumberMapper {

  default String map(PhoneNumber phoneNumber) {
    return phoneNumber.getValue();
  }

  default PhoneNumber map(String value) {
    return new PhoneNumber(value);
  }
}