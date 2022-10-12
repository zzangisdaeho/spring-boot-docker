package com.example.dockerapiassign.dto;

import com.example.dockerapiassign.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentSearchRequest {

    private String studentName;

    private Integer studentAge;

    private StudentEntity.Departments department;
}
