package com.github.billy.covinoc.user.application.port.out;

import com.github.billy.covinoc.user.domain.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface SaveUser {

  @Valid User save(@Valid User user);
}
