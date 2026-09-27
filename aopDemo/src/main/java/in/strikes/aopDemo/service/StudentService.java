package in.strikes.aopDemo.service;

import in.strikes.aopDemo.dto.Student;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Timestamp
    public Student createStudent(Student student){
        System.out.println("Student created successfully");
        return student;
    }

//    public String dummyMethod(String s) {
//        return s;
//    }

    public String getStudent(String s) {
        System.out.println(s);
        return s;
    }
}
