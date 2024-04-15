package com.example.ex_mtom.Service;


import com.example.ex_mtom.Api.ApiException;
import com.example.ex_mtom.Model.Course;
import com.example.ex_mtom.Model.Student;
import com.example.ex_mtom.Model.Teacher;
import com.example.ex_mtom.Repository.CourseRepository;
import com.example.ex_mtom.Repository.StudentRepository;
import com.example.ex_mtom.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository ;
    private final TeacherRepository teacherRepository ;
    private final StudentRepository studentRepository;


    public List<Course> getAll (){
        return courseRepository.findAll();
    }


    public void addCourse(Course course){

        courseRepository.save(course);
    }



    public void update(Integer Id , Course course){

        Course c = courseRepository.findCourseById(Id);

        if (c == null){
            throw new ApiException("Invalid Id");
        }

        c.setName(course.getName());


        courseRepository.save(c);

    }



    public void delete(Integer Id){

        Course c = courseRepository.findCourseById(Id);

        if (c == null){
            throw new ApiException("Invalid Id");
        }


        courseRepository.delete(c);

    }




    public void assignCourseToTeacher(Integer CourseId , Integer TeacherId){
        Course c = courseRepository.findCourseById(CourseId);
        Teacher t = teacherRepository.findTeacherById(TeacherId);

        if (c == null || t == null){
            throw new ApiException("cannot assign");
        }

        c.setTeacher(t);

        courseRepository.save(c);
    }



    public void assignStudentToCourse(Integer studentId , Integer courseId){
        Course c = courseRepository.findCourseById(courseId);
        Student s = studentRepository.findStudentById(studentId);

        if (c == null || s == null){
            throw new ApiException("cannot assign");
        }

        c.setStudent((List<Student>) s);

        studentRepository.save(s);
    }

    //    endpoint


    public String getTeacherByCourseID(Integer CourseId){

        Course c = courseRepository.findCourseById(CourseId);
        Teacher t = teacherRepository.findTeacherById(c.getTeacher().getId());

        if (c == null || t == null){
            throw new ApiException("invalid teacher id or course id");
        }

        return t.getName();

    }


    
    public List<Student> findStudentByClassId(Integer ClassId){
        Course c = courseRepository.findCourseById(ClassId);
        if (c == null){
            throw new ApiException("cannot find student");
        }

        return c.getStudent();

    }
}
