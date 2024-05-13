package com.kogutenko.clearsolutions.common.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class LowercaseListDeserializer extends JsonDeserializer<List<String>> {

    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        List<String> originalList = p.readValueAs(new TypeReference<List<String>>() {});
        return originalList.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
