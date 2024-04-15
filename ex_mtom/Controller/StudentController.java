package com.example.ex_mtom.Controller;


import com.example.ex_mtom.Api.ApiResponse;
import com.example.ex_mtom.Model.Student;
import com.example.ex_mtom.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;


    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(studentService.get());
    }



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid Student student){

        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("Student added"));

    }




    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id , @RequestBody @Valid Student student){

        studentService.update(id, student);

        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){

        studentService.delete(id);

        return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
    }





    //endpoint


    @GetMapping("/change/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id , @PathVariable String major){
        studentService.changeMajor(id, major);

        return ResponseEntity.status(200).body(new ApiResponse("Student updated"));
    }
}
