package com.example.ex_mtom.Repository;

import com.example.ex_mtom.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    Course findCourseById(Integer id);
}
