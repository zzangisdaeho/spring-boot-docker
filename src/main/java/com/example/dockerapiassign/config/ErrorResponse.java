package com.example.dockerapiassign.config;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String message;

    private final String path;

    private final ZonedDateTime timeStamp;
}
