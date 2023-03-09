package com.example.crudentityManager.service;

import com.example.crudentityManager.entity.Student;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    public Student saveStudent(Student student);

    public Student deleteStudent(Student student);

    public Student updateStudent(Student student);

    public Student getStudent(int id);

}