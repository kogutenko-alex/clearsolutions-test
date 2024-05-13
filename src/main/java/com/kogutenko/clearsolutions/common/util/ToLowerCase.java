package com.kogutenko.clearsolutions.common.util;

import com.fasterxml.jackson.databind.util.StdConverter;

public class ToLowerCase extends StdConverter<String, String> {

    @Override
    public String convert(String value) {
        return value.toLowerCase();
    }
}
