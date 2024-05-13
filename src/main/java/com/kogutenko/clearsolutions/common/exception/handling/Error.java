package com.kogutenko.clearsolutions.common.exception.handling;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import static lombok.AccessLevel.PROTECTED;

@Data
@SuperBuilder(toBuilder = true)
@RequiredArgsConstructor
@FieldDefaults(level = PROTECTED)
public class Error {

    String message;

}
