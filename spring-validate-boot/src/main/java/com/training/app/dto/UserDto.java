package com.training.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;
    @NotBlank(message = "Name not null")
    private String name;
    @NotBlank(message = "Email not null")
    @Email(message = "Email sai dinh dang")
    private String email;
    @Min(value = 18, message = "Not duoi 18")
    private int age;
}
