package com.kogutenko.clearsolutions.user.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kogutenko.clearsolutions.common.util.ToLowerCase;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
@FieldDefaults(level = PRIVATE)
public class UserPutInDto {

    @NotBlank(message = "Missing required parameter 'firstName'")
    String firstName;

    @NotBlank(message = "Missing required parameter 'lastName'")
    String lastName;

    @JsonDeserialize(converter = ToLowerCase.class)
    @NotBlank(message = "Missing required parameter 'email'")
    @Email(message = "Invalid email address")
    String email;

    @Past(message = "Birth date must be in the past")
    @NotNull(message = "Birth date is required")
    Instant birthDate;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[0-9]{7,10}$", message = "Invalid phone number")
    String phone;

    String address;

}
