package in.strikes.filtersDemo.controller;

import in.strikes.filtersDemo.dto.Student;
import in.strikes.filtersDemo.dto.StudentResponseDto;
import in.strikes.filtersDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService=new StudentService();
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody Student student){
        StudentResponseDto responseDto=
                studentService.createStudent(student);
        return ResponseEntity.ok(responseDto);
    }

}
