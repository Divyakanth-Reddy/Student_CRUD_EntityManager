package com.example.crudentityManager.service;

import com.example.crudentityManager.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

// Marks it as Spring bean , using which we can inject into other parts of application using " DI " , as done in StudentController class using @autowired annotation
@Service("studentServiceImpl") //this is the Bean ID
public class StudentServiceImpl implements StudentService {

    @PersistenceContext // is used to inject an EntityManager instance, which is used to interact with the database.
    private EntityManager entityManger;

    @Transactional // ensures that the code in this method will be executed within a transactional context.
    public Student saveStudent(Student student) {
        entityManger.persist(student);
        return student;
    }

    // This means that if any exception occurs, the transaction will be rolled back
    // to the last committed state, ensuring that the database is not left in an inconsistent state.
    @Transactional
    public Student updateStudent(Student student) {
        entityManger.merge(student);
        return student;
    }

    @Transactional
    public Student deleteStudent(Student student) {
        if (entityManger.contains(student)) {
            entityManger.remove(student);
        } else {
            entityManger.remove(entityManger.merge(student));
        }

        return student;
    }

    @Transactional
    public Student getStudent(int id) {
        Student response = (Student) entityManger.find(Student.class, id);
        return response;
    }

}
