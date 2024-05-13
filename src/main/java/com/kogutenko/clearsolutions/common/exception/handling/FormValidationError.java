package com.kogutenko.clearsolutions.common.exception.handling;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PRIVATE;

@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE)
public class FormValidationError extends Error {

    String field;

}
