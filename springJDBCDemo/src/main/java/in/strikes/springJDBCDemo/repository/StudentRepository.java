package in.strikes.springJDBCDemo.repository;

import in.strikes.springJDBCDemo.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

//    private StudentRowMapper studentRowMapper =new StudentRowMapper();

    private RowMapper<Student> rowMapper=
            new BeanPropertyRowMapper<>(Student.class);

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void createUser(Student student) {
            String sql = """
                   INSERT INTO students(name,email,age)                      
                    VALUES(? ,?,?)
                    """;

            int rowAffected=jdbcTemplate.update
                    (sql,student.getName(),student.getEmail(),student.getAge());

            if(rowAffected==1){
                System.out.println("Create operation performed");
            }
            else {
                System.out.println("Create operation not performed");
            }
    }

        public void updateUser(Student student ,long id){
            String sql= """
                        UPDATE students
                        SET name=?,
                            email=?,
                            age=?
                        WHERE id=?
                        """;

            int rowAffected=jdbcTemplate.update
                    (sql,student.getName(),student.getEmail(),student.getAge(),id);

            if(rowAffected==1){
                System.out.println("Update operation performed");
            }
            else{
                System.out.println("Update operation not performed");
            }

        }

        public void deleteUser(Long id){
            String sql= """
                        DELETE from students WHERE id=?
                        """;

            int rowAffected=jdbcTemplate.update
                    (sql,id);

            if(rowAffected==1){
                System.out.println("Update operation performed");
            }
            else{
                System.out.println("Update operation not performed");
            }
        }

        public Student getUserById(Long id){
            String sql= """
                        SELECT name,email,age FROM students
                        WHERE id=?
                        """;

            return jdbcTemplate.queryForObject(sql,rowMapper);
            

        }

        public List<Student> getStudent(){

            String sql= """
                        SELECT name,email,age FROM students
                        """;

            List<Student> students=jdbcTemplate.query(sql,rowMapper);
            return students;
        }

//        public void completeCRUD(){
//            try{
//                Connection connection= DriverManager.getConnection(url,username,password);
//
//                Statement statement=connection.createStatement();
//
//                String sql="SELECT * from students WHERE id=4";
//                boolean result=statement.execute(sql);
//                // if result is true , we will get a resultSet
//                // if result is false , we will get an integer (no of rows affected)
//                if(result){
//                    ResultSet resultSet=statement.getResultSet();
//                }
//                else{
//                    Integer ans=statement.getUpdateCount();
//                }
//
//                connection.close();
//            }
//            catch (SQLException e) {
//                System.out.println("Database connection failed");
//
//                e.printStackTrace();
//            }
//        }
}
