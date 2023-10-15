package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;

    public void SaveStudent(Student student){
        studentRepository.save(student);
    }
    public List<Student> FindAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> FindAllStudentByschool(Integer schoolId) {
        return studentRepository.findAllBySchoolId(schoolId);
    }
}
