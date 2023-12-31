package com.apper.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BlogBloggerDetails {

    @JsonProperty("title")
    private String title;

    @JsonProperty("body")
    private String body;

    @JsonProperty("date_created")
    private LocalDateTime createdDate;

    @JsonProperty("last_updated")
    private LocalDateTime updatedDate;
}