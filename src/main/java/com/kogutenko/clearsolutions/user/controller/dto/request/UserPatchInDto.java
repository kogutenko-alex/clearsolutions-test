package com.kogutenko.clearsolutions.user.controller.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kogutenko.clearsolutions.common.util.ToLowerCase;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.Optional;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(NON_NULL)
@FieldDefaults(level = PRIVATE)
public class UserPatchInDto {

    @NotBlank(message = "Missing required parameter 'firstName'")
    Optional<String> firstName;

    @NotBlank(message = "Missing required parameter 'lastName'")
    Optional<String> lastName;

    @JsonDeserialize(converter = ToLowerCase.class)
    @NotBlank(message = "Missing required parameter 'email'")
    @Email(message = "Invalid email address")
    Optional<String> email;

    @Past(message = "Birth date must be in the past")
    @NotNull(message = "Missing required parameter 'birthDate'")
    Optional<Instant> birthDate;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[0-9]{7,10}$", message = "Invalid phone number")
    Optional<String> phone;

    Optional<String> address;

    public void setPhone(String phone) {
        this.phone = Optional.ofNullable(phone);
    }

    public void setAddress(String address) {
        this.address = Optional.ofNullable(address);
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = Optional.ofNullable(birthDate);
    }

    public void setFirstName(String firstName) {
        this.firstName = Optional.ofNullable(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = Optional.ofNullable(lastName);
    }
}
