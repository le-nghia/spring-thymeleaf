package com.example.demothymeleaf.service;

import com.example.demothymeleaf.entity.Student;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<Student> getAll();

    void saveStudent(Student student);
    void deleteUser(Long id);
    Optional<Student> findUserById(Long id);
    Page<Student> findPaginated(int pageNo, int pageSize);
    List<Student> searchUser(String keyword);
}
