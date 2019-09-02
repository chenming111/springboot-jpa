package com.cardarc.spring.boot.jpa;


import com.cardarc.spring.boot.jpa.domain.Student;
import com.cardarc.spring.boot.jpa.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class JpaTest {

    @Autowired(required = true)
    private StudentRepository repository;

    @Test
    public void test(){
        List<Student> students = repository.findAll();

        System.out.println(students);

    }


}
