package com.example.ex_mtom.Repository;

import com.example.ex_mtom.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {


    Student findStudentById(Integer id);
}
