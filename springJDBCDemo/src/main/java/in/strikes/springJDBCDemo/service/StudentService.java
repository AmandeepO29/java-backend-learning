package in.strikes.springJDBCDemo.service;

    import in.strikes.springJDBCDemo.model.Student;
    import in.strikes.springJDBCDemo.repository.StudentRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class StudentService {

        private StudentRepository studentRepository;

        public StudentService(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

        public void createStudent(Student student) {
            studentRepository.createUser(student);
        }

        public List<Student> getAllStudents() {
            return studentRepository.getStudent();
        }

        public Student getStudentById(Long id) {
            return studentRepository.getUserById(id);
        }

        public void updateStudent(Student student) {
            studentRepository.updateUser(student,student.getId());
        }

        public void deleteStudent(Long id) {
            studentRepository.deleteUser(id);
        }
    }

