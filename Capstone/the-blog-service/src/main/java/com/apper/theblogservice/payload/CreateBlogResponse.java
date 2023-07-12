package com.apper.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@Data
public class CreateBlogResponse {
    private String id;

    @JsonProperty("blogger_id")
    private String bloggerId;

    @JsonProperty("date_created")
    private LocalDateTime dateCreated;

    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;
}
