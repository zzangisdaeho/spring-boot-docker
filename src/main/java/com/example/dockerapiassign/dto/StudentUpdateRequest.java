package com.example.dockerapiassign.dto;

import com.example.dockerapiassign.entity.StudentEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentUpdateRequest {

    private String studentName;

    private Integer studentAge;

    private StudentEntity.Departments department;
}
