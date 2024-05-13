package com.kogutenko.clearsolutions.user.service.filter;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

import static lombok.AccessLevel.PROTECTED;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PROTECTED)
public class UserFilter {

    @Schema(example = "2024-05-12T21:00:00Z")
    Instant afterDate;

    @Schema(example = "2024-05-14T21:00:00Z")
    Instant beforeDate;

}
