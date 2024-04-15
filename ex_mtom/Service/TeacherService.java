package com.example.ex_mtom.Service;


import com.example.ex_mtom.Api.ApiException;
import com.example.ex_mtom.Model.Teacher;
import com.example.ex_mtom.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherService {


    private final TeacherRepository teacherRepository ;


    public List<Teacher> get(){
        return teacherRepository.findAll();
    }


    public void addTeacher(Teacher teacher){

        teacherRepository.save(teacher);
    }


    public void update(Integer Id , Teacher teacher){

        Teacher t = teacherRepository.findTeacherById(Id);

        if (t == null){
            throw new ApiException("Invalid Id");
        }

        t.setName(teacher.getName());
        t.setAge(teacher.getAge());
        t.setEmail(teacher.getEmail());
        t.setSalary(teacher.getSalary());

        teacherRepository.save(t);


    }



    public void delete(Integer Id){

        Teacher t = teacherRepository.findTeacherById(Id);

        if (t == null){
            throw new ApiException("Invalid Id");
        }


        teacherRepository.delete(t);

    }



    public Teacher getTeacherById(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);

        if (teacher == null){
            throw new ApiException("teacher not found");
        }
        return teacher ;
    }



}
