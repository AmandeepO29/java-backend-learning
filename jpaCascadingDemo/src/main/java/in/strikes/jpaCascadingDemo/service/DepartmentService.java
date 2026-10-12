package in.strikes.jpaCascadingDemo.service;


import in.strikes.jpaCascadingDemo.controller.DepartmentController;
import in.strikes.jpaCascadingDemo.model.Department;
import in.strikes.jpaCascadingDemo.model.Student;
import in.strikes.jpaCascadingDemo.repository.DepartmentRepository;
import in.strikes.jpaCascadingDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;

    public DepartmentService(DepartmentRepository departmentRepository,StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        Student s1=new Student();
        s1.setName("AMANDEEP");
        s1.setDepartment(department);

        Student s2=new Student();
        s2.setName("Akash");
        s2.setDepartment(department);

        Student s3=new Student();
        s3.setName("Aditya");
        s3.setDepartment(department);

        Student s4=new Student();
        s4.setName("Rohan");
        s4.setDepartment(department);

//        department.getStudents().addAll(List.of(s1,s2,s3,s4));

        departmentRepository.save(department);
//       this can be done automatically by the CASCADE....
//        studentRepository.save(s1);
//        studentRepository.save(s2);
//        studentRepository.save(s3);
//        studentRepository.save(s4);

    }

    @Transactional
    public void removeDepartment(Long id){

        Department department=departmentRepository.findById(id);
        departmentRepository.removeDepartment(department);
    }
}
