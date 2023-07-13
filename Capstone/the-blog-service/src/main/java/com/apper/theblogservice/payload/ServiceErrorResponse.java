package com.apper.theblogservice.payload;

import lombok.Data;

@Data
public class ServiceErrorResponse {
    private String error;
    private String message;
}