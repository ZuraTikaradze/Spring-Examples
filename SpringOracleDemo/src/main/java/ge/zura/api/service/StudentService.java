package ge.zura.api.service;

import ge.zura.api.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getStudents();
    Student getStudent(Long id);
    void addStudent(Student student);
    void updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
