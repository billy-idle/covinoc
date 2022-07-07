package com.github.billy.covinoc.user.application.mapper;

import com.github.billy.covinoc.common.domain.type.Id;
import com.github.billy.covinoc.common.domain.type.NumberId;
import com.github.billy.covinoc.common.domain.type.status.Status;
import com.github.billy.covinoc.common.mapper.IdMapper;
import com.github.billy.covinoc.common.mapper.NameMapper;
import com.github.billy.covinoc.common.mapper.NumberIdMapper;
import com.github.billy.covinoc.common.mapper.PhoneNumberMapper;
import com.github.billy.covinoc.common.mapper.StatusMapper;
import com.github.billy.covinoc.common.utilities.Utility;
import com.github.billy.covinoc.user.adapter.out.persistence.UserJpaEntity;
import com.github.billy.covinoc.user.application.port.in.UserCreateRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserDeleteRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserFindByIdRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.in.UserUpdateRequestModel;
import com.github.billy.covinoc.user.domain.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", imports = {Id.class, Status.class}, uses = {IdMapper.class,
    NameMapper.class, NumberIdMapper.class, PhoneNumberMapper.class, StatusMapper.class},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

  UserJpaEntity toJpaEntity(User user);

  @Mapping(target = "id", expression = "java(new Id(0))")
  @Mapping(target = "status", expression = "java(Status.ACTIVE)")
  User toDomain(UserCreateRequestModel userCreateRequestModel);

  default List<User> toDomain(List<UserJpaEntity> userJpaEntities) {
    return userJpaEntities.stream().map(this::toDomain).collect(Collectors.toList());
  }

  User toDomain(UserJpaEntity userEntity);

  User toDomain(UserUpdateRequestModel userUpdateRequestModel);

  @Mapping(source = "numberId", target = "value")
  NumberId toNumberId(UserDeleteRequestModel userDeleteRequestModel);

  @Mapping(source = "numberId", target = "value")
  NumberId toNumberId(UserFindByIdRequestModel userFindByIdRequestModel);

  default List<UserResponseModel> toResponseModel(List<User> users) {
    return users.stream().map(this::toResponseModel).collect(Collectors.toList());
  }

  UserResponseModel toResponseModel(User user);

  default JSONObject toJson(UserCreateRequestModel userCreateRequestModel) throws JSONException {
    JSONObject jsonObject = new JSONObject();

    jsonObject.put("id", new Id(Utility.INTEGER_ZERO));
    jsonObject.put("name", userCreateRequestModel.getName());
    jsonObject.put("numberId", userCreateRequestModel.getNumberId());
    jsonObject.put("phoneNumber", userCreateRequestModel.getPhoneNumber());

    return jsonObject;
  }
}
