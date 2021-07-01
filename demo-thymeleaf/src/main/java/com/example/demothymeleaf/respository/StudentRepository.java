package com.example.demothymeleaf.respository;

import com.example.demothymeleaf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {
    @Query(value = "select * from user where concat(id,'',name,'',email,'',phone) like %?1%",nativeQuery = true)
    List<Student> search(String pageable);
}
