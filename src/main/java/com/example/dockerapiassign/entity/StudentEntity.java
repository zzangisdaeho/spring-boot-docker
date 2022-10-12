package com.example.dockerapiassign.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentNo;

    private String studentName;

    private Integer studentAge;

    @Enumerated(EnumType.STRING)
    private Departments department;

    public enum Departments{
        MATH("수학과"), COMPUTE_SCIENCE("컴퓨터학과"), BUSINESS("경영학과");

        private String ko;

        Departments(String ko) {
            this.ko = ko;
        }

        public String getKo() {
            return ko;
        }
    }

    public void updateInfo(String studentName, Integer studentAge, Departments department){
        this.studentName = StringUtils.hasText(studentName) ? studentName : this.studentName;
        this.studentAge = studentAge != null? studentAge : this.studentAge;
        this.department = department != null? department : this.department;
    }

}
