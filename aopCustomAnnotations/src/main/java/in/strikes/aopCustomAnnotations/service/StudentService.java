package in.strikes.aopCustomAnnotations.service;

import in.strikes.aopCustomAnnotations.annotation.TrackExecutionTime;
import in.strikes.aopCustomAnnotations.dto.Student;
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


    @TrackExecutionTime(
            warnAfter = 900,
            operation = "Get student data"
    )
    public String getStudent(String s) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println(s);
        return s;
    }
}
