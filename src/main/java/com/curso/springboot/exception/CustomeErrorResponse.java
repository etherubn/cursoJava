package com.curso.springboot.exception;

import java.time.LocalDateTime;

public record CustomeErrorResponse(
        LocalDateTime dateTime,
        String message,
        String path
) {
}
