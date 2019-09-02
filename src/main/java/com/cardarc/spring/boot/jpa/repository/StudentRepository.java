package com.cardarc.spring.boot.jpa.repository;

import com.cardarc.spring.boot.jpa.domain.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

     List<Student> findAll();
}
