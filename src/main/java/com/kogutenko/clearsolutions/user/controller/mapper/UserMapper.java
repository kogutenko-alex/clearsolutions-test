package com.kogutenko.clearsolutions.user.controller.mapper;

import com.kogutenko.clearsolutions.user.controller.dto.request.UserPatchInDto;
import com.kogutenko.clearsolutions.user.controller.dto.request.UserPutInDto;
import com.kogutenko.clearsolutions.user.controller.dto.response.UserOutDto;
import com.kogutenko.clearsolutions.user.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    User toEntity(UserPutInDto userDto);

    UserOutDto toDto(User user);

    default Page<UserOutDto> toListDto(Page<User> users) {
        return users.map(this::toDto);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    void putMarge(UserPutInDto inDto, @MappingTarget User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "firstName", expression = "java(java.util.Objects.isNull(inDto.getFirstName()) ? user.getFirstName() : inDto.getFirstName().orElse(null))")
    @Mapping(target = "lastName", expression = "java(java.util.Objects.isNull(inDto.getLastName()) ? user.getLastName() : inDto.getLastName().orElse(null))")
    @Mapping(target = "email", expression = "java(java.util.Objects.isNull(inDto.getEmail()) ? user.getEmail() : inDto.getEmail().orElse(null))")
    @Mapping(target = "birthDate", expression = "java(java.util.Objects.isNull(inDto.getBirthDate()) ? user.getBirthDate() : inDto.getBirthDate().orElse(null))")
    @Mapping(target = "phone", expression = "java(java.util.Objects.isNull(inDto.getPhone()) ? user.getPhone() : inDto.getPhone().orElse(null))")
    @Mapping(target = "address", expression = "java(java.util.Objects.isNull(inDto.getAddress()) ? user.getAddress() : inDto.getAddress().orElse(null))")
    void patchMarge(UserPatchInDto inDto, @MappingTarget User user);

}
