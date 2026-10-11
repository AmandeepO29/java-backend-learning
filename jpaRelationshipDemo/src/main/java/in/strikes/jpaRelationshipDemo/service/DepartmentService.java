package in.strikes.jpaRelationshipDemo.service;

import in.strikes.jpaRelationshipDemo.model.Department;
import in.strikes.jpaRelationshipDemo.model.Student;
import in.strikes.jpaRelationshipDemo.repository.DepartmentRepository;
import in.strikes.jpaRelationshipDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    StudentRepository studentRepository;
    public DepartmentService(DepartmentRepository departmentRepository,
                             StudentRepository studentRepository) {
        this.departmentRepository = departmentRepository;
        this.studentRepository=studentRepository;
    }

    @Transactional
    public void createDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public void createDepartment(Department department, String studentName)
    {
        Student student=new Student();
        student.setName(studentName);
        student.setDepartment(department);

        department.getStudents().add(student);

        studentRepository.save(student);
        departmentRepository.save(department);
    }
}
