package com.kogutenko.clearsolutions.user.controller.facade.impl;

import com.kogutenko.clearsolutions.user.controller.dto.request.UserPatchInDto;
import com.kogutenko.clearsolutions.user.controller.dto.request.UserPutInDto;
import com.kogutenko.clearsolutions.user.controller.dto.response.UserOutDto;
import com.kogutenko.clearsolutions.user.controller.facade.UserFacade;
import com.kogutenko.clearsolutions.user.controller.mapper.UserMapper;
import com.kogutenko.clearsolutions.user.repository.entity.User;
import com.kogutenko.clearsolutions.user.service.UserService;
import com.kogutenko.clearsolutions.user.service.filter.UserFilter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserFacadeImpl implements UserFacade {

    UserService userService;

    UserMapper userMapper;

    @Override
    public Page<UserOutDto> findAll(UserFilter filter, Pageable pageable) {
        Page<User> usersPage = userService.findAll(filter, pageable);
        return userMapper.toListDto(usersPage);
    }

    @Override
    public UserOutDto find(UUID userId) {
        User user = userService.find(userId);
        return userMapper.toDto(user);
    }

    @Override
    public UserOutDto createUser(UserPutInDto inDto) {
        User user = userMapper.toEntity(inDto);

        User newUser = userService.save(user);
        return userMapper.toDto(newUser);
    }

    @Transactional
    @Override
    public UserOutDto putUser(UUID userId, UserPutInDto inDto) {
        User user = userService.find(userId);

        userMapper.putMarge(inDto, user);
        User updated = userService.save(user);

        return userMapper.toDto(updated);
    }

    @Transactional
    @Override
    public UserOutDto patchUser(UUID userId, UserPatchInDto inDto) {
        User user = userService.find(userId);

        userMapper.patchMarge(inDto, user);
        User updated = userService.save(user);

        return userMapper.toDto(updated);
    }

    @Transactional
    @Override
    public void deleteUser(UUID userId) {
        User user = userService.find(userId);
        userService.delete(user);
    }

}
