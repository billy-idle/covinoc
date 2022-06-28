package com.github.billy.covinoc.common.mapper;

import com.github.billy.covinoc.common.domain.type.status.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {

  default String map(Status status) {
    return status.getValue();
  }

  default Status map(String value) {
    return Status.of(value);
  }
}
