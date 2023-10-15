package com.example.student;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentCotroller {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveStudent(@RequestBody Student student){
            studentService.SaveStudent(student);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> FindAllStudents(){
        return ResponseEntity.ok(studentService.FindAllStudent());
    }@GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> FindAllStudents(@PathVariable("school-id") Integer schoolId){

        return ResponseEntity.ok(studentService.FindAllStudentByschool(schoolId));
    }


}
