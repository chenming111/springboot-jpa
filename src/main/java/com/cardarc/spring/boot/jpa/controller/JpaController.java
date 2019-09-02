package com.cardarc.spring.boot.jpa.controller;

import com.cardarc.spring.boot.jpa.domain.Student;
import com.cardarc.spring.boot.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JpaController {
    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping("/queryall")
    @ResponseBody
    public List<Student> queryall(){
        List<Student> students=studentRepository.findAll();
        return students;
    }




}
