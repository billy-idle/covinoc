package com.github.billy.covinoc.common.mapper;

import com.github.billy.covinoc.common.domain.type.Id;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdMapper {

  default Integer map(Id id) {
    return id.getValue();
  }

  default Id map(Integer value) {
    return new Id(value);
  }
}