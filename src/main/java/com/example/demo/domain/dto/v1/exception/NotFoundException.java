package com.example.demo.domain.dto.v1.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NotFoundException extends Exception {
    private final Class clazz;
    private final String id;
}
