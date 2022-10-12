package com.example.dockerapiassign.repository;

import com.example.dockerapiassign.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Integer> {
}
