package ge.zura.api.service.impl;

import ge.zura.api.model.Student;
import ge.zura.api.repository.StudentRepository;
import ge.zura.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.getOne(id);
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Student currentStudent= studentRepository.findById(id).get();
        currentStudent.setName(student.getName());

    }

    @Override
    public void deleteStudent(Long id) {

    }
}
