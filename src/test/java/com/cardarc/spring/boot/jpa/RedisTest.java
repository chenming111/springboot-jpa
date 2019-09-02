package com.cardarc.spring.boot.jpa;


import com.cardarc.spring.boot.jpa.domain.Student;
import com.cardarc.spring.boot.jpa.repository.StudentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void test() throws JsonProcessingException {
        //1、从redis中获得数据，数据的形式json字符串
        String studentListJson = redisTemplate.boundValueOps("student.findAll").get();
        //2、判断redis中是否存在数据
        if (studentListJson==null){
            //不存在数据，从数据库查询
            List<Student> students = studentRepository.findAll();
            //将查询出的数据存储到redis缓存中
            //将list集合转换成json格式的字符串,使用jackson进行转换
            ObjectMapper objectMapper=new ObjectMapper();
            studentListJson = objectMapper.writeValueAsString(students);
            redisTemplate.boundValueOps("student.findAll").set(studentListJson);
            System.out.println("从数据库取得数据");
        }else{
            System.out.println("从redis取得数据");
        }
        System.out.println(studentListJson);
    }

}
