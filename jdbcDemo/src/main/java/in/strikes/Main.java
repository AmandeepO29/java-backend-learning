package in.strikes;

import in.strikes.model.Student;
import in.strikes.repository.StudentRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws SQLException {
        StudentRepository studentRepository=new StudentRepository();
        //studentRepository.createUser(new Student("AMAN" ,"a29@gmail.com",21));
        studentRepository.updateUser(
                new Student("Amandeep","a29godara@gmail.com",21),6L);
        //studentRepository.getUserById();
    }
}
