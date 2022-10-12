package com.example.dockerapiassign.dto;

import com.example.dockerapiassign.config.ValidEnum;
import com.example.dockerapiassign.entity.StudentEntity;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class StudentCreateRequest {

    @NotEmpty
    private String studentName;

    @NotNull
    private Integer studentAge;

    @ValidEnum(enumClass = StudentEntity.Departments.class)
    private StudentEntity.Departments department;

    public StudentEntity from(){
        return StudentEntity.builder()
                .studentName(studentName)
                .studentAge(studentAge)
                .department(department)
                .build();
    }
}
