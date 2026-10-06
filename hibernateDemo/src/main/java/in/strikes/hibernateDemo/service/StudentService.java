package in.strikes.hibernateDemo.service;

import in.strikes.hibernateDemo.model.Student;
import in.strikes.hibernateDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        studentRepository.save(student);
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void updateStudent(Student studentReq,Long id) {

        Student student1=studentRepository.findById(id);

        student1.setName(studentReq.getName());
        student1.setEmail(studentReq.getEmail());
        student1.setAge(studentReq.getAge());
    }

    @Transactional
    public void deleteStudent(Long id) {

        Student student =studentRepository.findById(id);
        if(student==null){
            throw new RuntimeException("Student not found");
        }

        studentRepository.remove(student);
    }
}


