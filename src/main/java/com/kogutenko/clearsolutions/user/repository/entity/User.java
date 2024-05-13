package com.kogutenko.clearsolutions.user.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "system_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
@SuperBuilder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    UUID id;

    @NotBlank(message = "Missing required parameter 'firstName'")
    @Column(name = "first_name")
    String firstName;

    @NotBlank(message = "Missing required parameter 'lastName'")
    @Column(name = "last_name")
    String lastName;

    @NotBlank(message = "Missing required parameter 'email'")
    @Email(message = "Invalid email address")
    @Column(name = "email")
    String email;

    @Past(message = "Birth date must be in the past")
    @NotNull(message = "Birth date is required")
    @Column(name = "birth_date")
    Instant birthDate;

    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[0-9]{7,10}$", message = "Invalid phone number")
    @Column(name = "phone")
    String phone;

    @Column(name = "address")
    String address;

    @LastModifiedDate
    @Column(name = "updated_date")
    Instant updatedDate;

    @CreatedDate
    @Column(name = "created_date")
    Instant createdDate;

}
