package in.strikes.aopDemo.controller;

import in.strikes.aopDemo.dto.Student;
import in.strikes.aopDemo.service.StudentService;
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
    public ResponseEntity<String> getStudent(Student student){
        return ResponseEntity.ok(studentService.getStudent(student));
    }
}
