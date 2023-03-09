package com.example.crudentityManager.controller;

import com.example.crudentityManager.entity.Student;
import com.example.crudentityManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)// we can write this in a simple way as shown below
    // @PostMapping("/save")
    // there is no need to use @ResponseBody because @RestController already includes this annotation from Spring 4.0 onwards
    @ResponseBody
    public Student saveStudent(@RequestBody Student student) {
        Student studentResponse = (Student) studentService.saveStudent(student);
        return studentResponse;
    }

    // @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        Student studentResponse = (Student) studentService.updateStudent(student);
        return studentResponse;
    }

    @DeleteMapping("/delete")
    public Student deleteStudent(@RequestBody Student student) {
        Student studentResponse = (Student) studentService.deleteStudent(student);
        return studentResponse;
    }


    @GetMapping("/find/{id}")
    public Student getStudent(@PathVariable int id) {

        Student studentResponse = (Student) studentService.getStudent(id);
        return studentResponse;
    }

}