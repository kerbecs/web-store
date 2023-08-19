package com.general.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BodyError {
    private String message;
    private String path;
    private Integer code;
    private Long timestamp;
}
