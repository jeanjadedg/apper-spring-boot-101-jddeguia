package com.apper.theblogservice.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBloggerRequest {

    @JsonProperty("name")
    @NotBlank(message = "Name is required.")
    private String name;

    @JsonProperty("email")
    @Email
    @NotBlank(message = "Email is required.")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters.")
    @NotBlank(message = "Password is required.")
    private String password;

}
