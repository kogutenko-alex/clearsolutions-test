package com.kogutenko.clearsolutions.user.controller.facade;

import com.kogutenko.clearsolutions.user.controller.dto.request.UserPatchInDto;
import com.kogutenko.clearsolutions.user.controller.dto.request.UserPutInDto;
import com.kogutenko.clearsolutions.user.controller.dto.response.UserOutDto;
import com.kogutenko.clearsolutions.user.service.filter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserFacade {

    Page<UserOutDto> findAll(UserFilter filter, Pageable pageable);

    UserOutDto find(UUID userId);

    UserOutDto createUser(UserPutInDto inDto);

    UserOutDto putUser(UUID userId, UserPutInDto inDto);

    UserOutDto patchUser(UUID userId, UserPatchInDto inDto);

    void deleteUser(UUID userId);

}
