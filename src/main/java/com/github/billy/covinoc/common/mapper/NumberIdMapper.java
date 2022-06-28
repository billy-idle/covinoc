package com.github.billy.covinoc.common.mapper;

import com.github.billy.covinoc.common.domain.type.NumberId;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NumberIdMapper {

  default String map(NumberId numberId) {
    return numberId.getValue();
  }

  default NumberId map(String value) {
    return new NumberId(value);
  }
}