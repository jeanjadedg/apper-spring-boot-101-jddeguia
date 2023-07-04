package com.apper.estore;


import com.fasterxml.jackson.annotation.JsonProperty;

public record ServiceError (@JsonProperty("verification_code") String message) {

}
