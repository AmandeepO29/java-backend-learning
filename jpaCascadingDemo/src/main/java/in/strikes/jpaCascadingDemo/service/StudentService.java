package in.strikes.jpaCascadingDemo.service;

import in.strikes.jpaCascadingDemo.model.Department;
import in.strikes.jpaCascadingDemo.model.Profile;
import in.strikes.jpaCascadingDemo.model.Student;
import in.strikes.jpaCascadingDemo.repository.DepartmentRepository;
import in.strikes.jpaCascadingDemo.repository.ProfileRepository;
import in.strikes.jpaCascadingDemo.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;
    DepartmentRepository departmentRepository;
    ProfileRepository profileRepository;

    public StudentService(StudentRepository studentRepository,
                          DepartmentRepository departmentRepository,
                          ProfileRepository profileRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
        this.profileRepository = profileRepository;
    }

    @Transactional
    public void createStudent(Student student) {
        Department department=new Department();
        department.setName("CSE");

        Profile profile=new Profile();
        profile.setBio("Simple Bio");

        student.setDepartment(department);
        student.setProfile(profile);

        departmentRepository.save(department);
        profileRepository.save(profile);
        studentRepository.save(student);
    }

    public Student fetchStudentById(Long id){
        Student s1=studentRepository.findById(id);
        System.out.println("Lazily fetched student");

        Department d1=s1.getDepartment();
        System.out.println("lazily fetched department");

        Profile p1=s1.getProfile();
        System.out.println("Lazily fetched profile");

        return s1;
    }
}
