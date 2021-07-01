package com.example.demothymeleaf.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "Vui lòng nhập tên SV.")
    @Column(name = "name", nullable = true)
    private String name;

    @NotBlank(message = "Vui lòng nhập email")
    @Pattern(regexp = "\\w+@\\w+\\.\\w+(,\\s*\\w+@\\w+\\.\\w+)*", message = "Email khôg đúng định dạng")
    @Column(name = "email", nullable = true)
    private String email;

    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Column(name = "phone", nullable = true)
    private String phone;
}
