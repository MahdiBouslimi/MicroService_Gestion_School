package com.example.school;

import com.example.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SchoolService {
    @Autowired
    private final SchoolRepository schoolRepository;

    private final StudentClient studentClient;
    public void SaveSchool(School school){
        schoolRepository.save(school);
    }
    public List<School> FindAllSchool(){
        return schoolRepository.findAll();
    }


    public  FullSchoolResponse  FindAllSchoolsWithStudents(Integer schoolId) {
        var school = schoolRepository.findById(schoolId)
                .orElse(
                        School.builder()
                                .name("NOT_FOUND")
                                .email("NOT_FOUND")
                                .build());
        var students = studentClient.findAllStudentsBySchool(schoolId); //find all the students from student micro-service
        return FullSchoolResponse
                .builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
