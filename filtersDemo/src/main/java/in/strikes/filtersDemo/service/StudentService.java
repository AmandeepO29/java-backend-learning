package in.strikes.filtersDemo.service;

import in.strikes.filtersDemo.dto.Student;
import in.strikes.filtersDemo.dto.StudentResponseDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public StudentResponseDto createStudent(Student student){
        StudentResponseDto responseDto=new StudentResponseDto();
        responseDto.setName(student.getName());
        responseDto.setMessage("Student is saved successfully");

        return responseDto;
    }
}
