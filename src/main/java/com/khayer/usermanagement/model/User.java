package com.khayer.usermanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@Document(collection = "users")
public class User {
    @Id
    private String id;

    @Size(max = 255)
    private String firstName;

    @Size(max = 255)
    private String lastName;

    @NotNull(message = "Email cannot be blank")
    @Size(max = 255)
    //@Pattern(regexp = "^(.+)@(\\\\S+)$")
    @Email
    @Indexed(unique = true)
    private String email;
}
