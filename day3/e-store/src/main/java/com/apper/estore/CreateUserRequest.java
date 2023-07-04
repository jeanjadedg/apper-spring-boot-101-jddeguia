package com.apper.estore;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateUserRequest {
    @NotBlank(message = "must not be blank")
    @Email(message = "invalid format")
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @JsonProperty("first_name")
    @NotBlank
    private String firstName;

    @JsonProperty("middle_name")
    private String middleName;

    @JsonProperty("last_name")
    @NotBlank
    private String lastName;

    @JsonProperty("birth_date")
    @NotBlank
    @Pattern(regexp = "[0-9]{4}-[0-9]{2}-[0-9]{2}")
    private String birthDate;


}