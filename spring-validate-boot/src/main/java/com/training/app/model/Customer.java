package com.training.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@AllArgsConstructor
public class Customer {

    @NotBlank(message = "Tên bắt buộc!")
    private String name;
    @NotEmpty(message = "Số CMND kông được để trống!!")
    private String cmnd;
    @Pattern(regexp = "\\d{10}", message = "Số điện thoại không đúng!")
    private String phone;
    @NotEmpty(message = "Không được để trống!")
    @Email(message = "Sai định dạng")
    private String email;

    public Customer() {

    }
}
