package com.example.ex_mtom.Controller;

import com.example.ex_mtom.Api.ApiResponse;
import com.example.ex_mtom.Model.Teacher;
import com.example.ex_mtom.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {


    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getAllTeacher(){
        return ResponseEntity.status(200).body(teacherService.get());
    }



    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher ){

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));

    }



    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id , @RequestBody @Valid Teacher teacher){

        teacherService.update(id, teacher);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        teacherService.delete(id);

        return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
    }




    @GetMapping("/getId/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.getTeacherById(id));
    }

}
