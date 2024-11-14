package org.example.springbootjdbc;

import org.example.springbootjdbc.model.Student;
import org.example.springbootjdbc.repo.StudentRepo;
import org.example.springbootjdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);

        Student stud = context.getBean(Student.class);
        stud.setId(1);
        stud.setName("John");
        stud.setMark(100);

        StudentService studSer = context.getBean(StudentService.class);
        studSer.addStudent(stud);

        List<Student> students = studSer.getStudents();
        System.out.println(students);
    }

}
