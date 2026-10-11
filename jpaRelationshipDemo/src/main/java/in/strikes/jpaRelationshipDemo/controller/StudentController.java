package in.strikes.jpaRelationshipDemo.controller;

import in.strikes.jpaRelationshipDemo.model.Student;
import in.strikes.jpaRelationshipDemo.service.StudentService;
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
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam Long deptId){
        studentService.createStudent(student,deptId);
        return ResponseEntity.ok("DONE");
    }

    @PostMapping("/withDepartment")
    public ResponseEntity<String> createStudent(@RequestBody Student student,
                                                @RequestParam String deptName){
        studentService.createStudent(student,deptName);
        return ResponseEntity.ok("DONE");
    }
}
