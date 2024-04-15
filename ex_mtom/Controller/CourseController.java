package com.example.ex_mtom.Controller;

import com.example.ex_mtom.Api.ApiResponse;
import com.example.ex_mtom.Model.Course;
import com.example.ex_mtom.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(courseService.getAll());
    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Course course ){

        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));

    }




    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id , @RequestBody @Valid Course course){

        courseService.update(id, course);

        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        courseService.delete(id);

        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }



    @PutMapping("/assign/{CourseId}/{TeacherId}")
    public ResponseEntity assignCourseToTeacher(@PathVariable Integer CourseId , @PathVariable Integer TeacherId){

        courseService.assignCourseToTeacher(CourseId, TeacherId);

        return ResponseEntity.status(200).body(new ApiResponse("Assign Done"));
    }


    @PutMapping("/assign/{studentId}/{courseId}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer studentId  , @PathVariable Integer courseId){
        courseService.assignStudentToCourse(studentId, courseId);

        return ResponseEntity.status(200).body(new ApiResponse("Assign Done"));
    }


    @GetMapping("/getC/{CourseId}")
    public ResponseEntity getTeacherByCourseID(@PathVariable Integer CourseId){

        return ResponseEntity.status(200).body(courseService.getTeacherByCourseID(CourseId));

    }


    @GetMapping("/getS/{ClassId}")
    public ResponseEntity getStudentByClassId(@PathVariable Integer ClassId){
        return ResponseEntity.status(200).body(courseService.findStudentByClassId(ClassId));
    }

}
