package in.strikes.jpaCascadingDemo.controller;

import in.strikes.jpaCascadingDemo.model.Student;
import in.strikes.jpaCascadingDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody Student student){

        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student student=studentService.fetchStudentById(id);
        return ResponseEntity.ok(student);
    }
}
