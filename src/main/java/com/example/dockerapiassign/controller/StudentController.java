package com.example.dockerapiassign.controller;

import com.example.dockerapiassign.dto.StudentCreateRequest;
import com.example.dockerapiassign.dto.StudentSearchRequest;
import com.example.dockerapiassign.dto.StudentUpdateRequest;
import com.example.dockerapiassign.entity.StudentEntity;
import com.example.dockerapiassign.repository.StudentEntityRepository;
import com.example.dockerapiassign.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;

    @GetMapping("/{id}")
    public StudentEntity getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }

    @GetMapping
    public List<StudentEntity> getStudent(@ModelAttribute StudentSearchRequest searchRequest){
        return studentService.searchStudent(searchRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentEntity createStudent(@Validated @RequestBody StudentCreateRequest studentCreateRequest){
        return studentService.createStudent(studentCreateRequest);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudent(@PathVariable int id, @Validated @RequestBody StudentUpdateRequest studentUpdateRequest){
        return studentService.updateStudent(id, studentUpdateRequest);
    }
}
