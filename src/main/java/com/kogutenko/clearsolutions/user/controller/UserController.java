package com.kogutenko.clearsolutions.user.controller;

import com.kogutenko.clearsolutions.common.response.PageResponse;
import com.kogutenko.clearsolutions.common.util.annotation.ApiPageable;
import com.kogutenko.clearsolutions.user.controller.dto.request.UserPatchInDto;
import com.kogutenko.clearsolutions.user.controller.dto.request.UserPutInDto;
import com.kogutenko.clearsolutions.user.controller.dto.response.UserOutDto;
import com.kogutenko.clearsolutions.user.controller.facade.UserFacade;
import com.kogutenko.clearsolutions.user.service.filter.UserFilter;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController {

    UserFacade userFacade;

    @ApiPageable
    @GetMapping
    public ResponseEntity<PageResponse<UserOutDto>> findAllUsers(@ParameterObject UserFilter filter,
                                                                 @Parameter(hidden = true) Pageable pageable) {

        Page<UserOutDto> response = userFacade.findAll(filter, pageable);
        return ResponseEntity.ok(new PageResponse<>(response.getContent(), response.getTotalElements()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutDto> findUser(@PathVariable UUID id) {
        UserOutDto response = userFacade.find(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<UserOutDto> createUser(@Valid @RequestBody UserPutInDto inDto) {
        UserOutDto response = userFacade.createUser(inDto);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserOutDto> putUser(@PathVariable UUID id, @Valid @RequestBody UserPutInDto inDto) {
        UserOutDto response = userFacade.putUser(id, inDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserOutDto> patchUser(@PathVariable UUID id, @RequestBody UserPatchInDto inDto) {
        UserOutDto response = userFacade.patchUser(id, inDto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userFacade.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
