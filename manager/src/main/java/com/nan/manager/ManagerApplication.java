package com.nan.manager;

import com.nan.manager.model.Student;
import com.nan.manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication  implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

    @Autowired
    private StudentService studentService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        studentService.saveStudent(new Student(1, "甜甜", "girl", "2001-02-07", "新乡", "艺术设计"));
        studentService.saveStudent(new Student(2, "楠先生", "boy", "1999-05-05", "商丘", "计算机科学与技术"));
        studentService.saveStudent(new Student(3, "王二奎", "female", "1995-02-19", "南京", "政府管理"));
        studentService.saveStudent(new Student(4, "Tom", "male", "1998-09-02", "the United States", "Foreign Language"));
    }
}
