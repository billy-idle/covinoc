package com.github.billy.covinoc.common.mapper;

import com.github.billy.covinoc.common.domain.type.Name;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NameMapper {

  default String map(Name name) {
    return name.getValue();
  }

  default Name map(String value) {
    return new Name(value);
  }
}