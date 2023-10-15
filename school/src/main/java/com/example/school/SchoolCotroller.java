package com.example.school;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolCotroller {
    @Autowired
    private SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void saveSchool(@RequestBody School school){
        schoolService.SaveSchool(school);
    }

    @GetMapping("/all")
    public ResponseEntity<List<School>> FindAllSchools(){
        return ResponseEntity.ok(schoolService.FindAllSchool());
    }


    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> FindAllSchoolsWithStudents(@PathVariable("school-id")  Integer schoolId){
        return ResponseEntity.ok(schoolService.FindAllSchoolsWithStudents(schoolId));
    }

}
