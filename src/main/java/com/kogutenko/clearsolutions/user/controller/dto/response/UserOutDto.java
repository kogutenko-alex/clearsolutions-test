package com.kogutenko.clearsolutions.user.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@FieldDefaults(level = PRIVATE)
public class UserOutDto {

    @JsonProperty(required = true)
    UUID id;

    @JsonProperty(required = true)
    String firstName;

    @JsonProperty(required = true)
    String lastName;

    @JsonProperty(required = true)
    String email;

    @JsonProperty(required = true)
    Instant birthDate;

    String phone;

    String address;

    Instant updatedDate;

    @JsonProperty(required = true)
    Instant createdDate;

}
