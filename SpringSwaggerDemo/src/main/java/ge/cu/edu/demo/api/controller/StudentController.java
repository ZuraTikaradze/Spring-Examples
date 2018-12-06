package ge.cu.edu.demo.api.controller;

import ge.cu.edu.demo.api.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return null;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Long id) {
        System.out.println(id);
        Student student=new Student();
        student.setId(id);
        student.setName("zura");
        return student;
    }

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student) {
        System.out.println(student);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable Long id) {
        System.out.println(id);
        System.out.println(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        System.out.println(id);
    }
}
