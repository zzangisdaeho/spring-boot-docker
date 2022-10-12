package com.example.dockerapiassign.service;

import com.example.dockerapiassign.dto.StudentCreateRequest;
import com.example.dockerapiassign.dto.StudentSearchRequest;
import com.example.dockerapiassign.dto.StudentUpdateRequest;
import com.example.dockerapiassign.entity.StudentEntity;
import com.example.dockerapiassign.repository.StudentEntityRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static com.example.dockerapiassign.entity.QStudentEntity.studentEntity;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentEntityRepository studentEntityRepository;
    private final JPAQueryFactory query;

    public StudentEntity getStudent(int id) {
        return this.findStudent(id);
    }

    @Transactional
    public StudentEntity createStudent(StudentCreateRequest studentCreateRequest) {
        return studentEntityRepository.save(studentCreateRequest.from());
    }

    @Transactional
    public void deleteStudent(int id) {
        studentEntityRepository.deleteById(id);
    }

    @Transactional
    public StudentEntity updateStudent(int id, StudentUpdateRequest studentUpdateRequest) {
        StudentEntity findStudent = findStudent(id);
        findStudent.updateInfo(studentUpdateRequest.getStudentName(), studentUpdateRequest.getStudentAge(), studentUpdateRequest.getDepartment());

        return findStudent;
    }

    private StudentEntity findStudent(int id) {
        return studentEntityRepository.findById(id).orElseThrow(() -> new NoSuchElementException("그딴 학생 존재하지 않는다"));
    }

    public List<StudentEntity> searchStudent(StudentSearchRequest searchRequest) {
        return query.selectFrom(studentEntity)
                .where(
                        studentNameSearch(searchRequest.getStudentName()),
                        studentAgeSearch(searchRequest.getStudentAge()),
                        studentDepartSearch(searchRequest.getDepartment())
                )
                .fetch();
    }

    private BooleanExpression studentNameSearch(String studentName) {
        return Objects.nonNull(studentName) ? studentEntity.studentName.contains(studentName) : null;
    }

    private BooleanExpression studentAgeSearch(Integer studentAge) {
        return Objects.nonNull(studentAge) ? studentEntity.studentAge.eq(studentAge) : null;
    }

    private BooleanExpression studentDepartSearch(StudentEntity.Departments department) {
        return Objects.nonNull(department) ? studentEntity.department.eq(department) : null;
    }
}
