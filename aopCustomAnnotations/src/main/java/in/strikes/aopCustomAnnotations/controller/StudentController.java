package in.strikes.aopCustomAnnotations.controller;

import in.strikes.aopCustomAnnotations.dto.Student;
import in.strikes.aopCustomAnnotations.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    public StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @GetMapping
    public ResponseEntity<String> getStudent(Student student) throws InterruptedException {
        return ResponseEntity.ok(studentService.getStudent(""));
    }
}
