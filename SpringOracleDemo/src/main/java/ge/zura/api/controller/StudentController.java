package ge.zura.api.controller;


import ge.zura.api.model.Student;
import ge.zura.api.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @RequestMapping(value = "/students",method = RequestMethod.GET) //@GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {

        return studentService.getStudent(id);
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id) {
        studentService.updateStudent(id,student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        System.out.println(id);
    }
}