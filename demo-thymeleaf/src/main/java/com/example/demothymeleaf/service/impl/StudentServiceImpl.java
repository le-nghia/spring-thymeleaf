package com.example.demothymeleaf.service.impl;

import com.example.demothymeleaf.entity.Student;
import com.example.demothymeleaf.respository.StudentRepository;
import com.example.demothymeleaf.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.saveAndFlush(student);
    }

    @Override
    public void deleteUser(Long id) {
        studentRepository.deleteAllById(Collections.singleton(id));

    }

    @Override
    public Optional<Student> findUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Student> findPaginated(int pageNo, int pageSize) {
        PageRequest pageable = PageRequest.of(pageNo-1, pageSize );
        return studentRepository.findAll(pageable);
    }

    @Override
    public List<Student> searchUser(String keyword) {
        return studentRepository.search(keyword);
    }
}
