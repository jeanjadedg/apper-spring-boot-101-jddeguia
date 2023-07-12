package com.apper.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Data
public class CreateBloggerResponse {
    private String id;

    @JsonProperty("date_registration")
    private LocalDateTime dateRegistration;
}
