package com.example.ex_mtom.Service;


import com.example.ex_mtom.Api.ApiException;
import com.example.ex_mtom.Model.Course;
import com.example.ex_mtom.Model.Student;
import com.example.ex_mtom.Model.Teacher;
import com.example.ex_mtom.Repository.CourseRepository;
import com.example.ex_mtom.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentRepository studentRepository ;
    private final CourseRepository courseRepository ;


    public List<Student> get(){
        return studentRepository.findAll();
    }


    public void addStudent(Student student){

        studentRepository.save(student);
    }


    public void update(Integer Id , Student student){

        Student s = studentRepository.findStudentById(Id);

        if (s == null){
            throw new ApiException("Invalid Id");
        }

        s.setName(student.getName());
        s.setAge(student.getAge());
        s.setMajor(student.getMajor());
        s.setMajor(student.getMajor());

        studentRepository.save(s);


    }




    public void delete(Integer Id){


        Student s = studentRepository.findStudentById(Id);

        if (s == null){
            throw new ApiException("Invalid Id");
        }


        studentRepository.delete(s);

    }






    // endpoint





    public void changeMajor(Integer id , String major){
        Student s = studentRepository.findStudentById(id);

        if (s == null){
            throw new ApiException("Invalid Id");
        }

        s.setCourses(null);
        s.setMajor(major);
        studentRepository.save(s);
    }

}
