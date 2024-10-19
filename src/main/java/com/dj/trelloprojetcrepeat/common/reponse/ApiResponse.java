package com.dj.trelloprojetcrepeat.common.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private final T data;
    private final String message;
}

