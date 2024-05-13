package com.kogutenko.clearsolutions.user.service;

import com.kogutenko.clearsolutions.user.repository.entity.User;
import com.kogutenko.clearsolutions.user.service.filter.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UserService {

    Page<User> findAll(UserFilter filter, Pageable pageable);

    User find(UUID userId);

    User save(User user);

    void delete(User user);

}
