package com.github.billy.covinoc.user.application.port.out;

import com.github.billy.covinoc.common.domain.type.NumberId;
import com.github.billy.covinoc.user.domain.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface FindUser {

  @Valid User findByNumberId(@Valid NumberId numberId);

  List<@Valid User> findAll();
}
