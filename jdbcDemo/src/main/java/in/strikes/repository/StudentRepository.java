package in.strikes.repository;

import in.strikes.model.Student;

import java.sql.*;

public class StudentRepository {

    String url="jdbc:mysql://localhost:3306/student_db" ;
    String username="root";
    String password="@Aman144429";

    public void createUser(Student student) {
        String sql = """
                   INSERT INTO students(name,email,age)                      
                    VALUES(? ,?,?)
                    """;
        try(
                Connection connection = DriverManager.getConnection(url, username, password);
                PreparedStatement preparedStatement= connection.prepareStatement(sql);
                ) {
//            Statement statement=connection.createStatement();

//            String sql="Insert INTO students(name,email,age)" +
//                    "VALUES('Aman' ,'aman@gmail.com','21')";

//            String sql= """
//                            Insert INTO students(name,email,age)
//                            VALUES('%s' ,'%s','%d')
//                            """.formatted(student.getName(),student.getEmail(),student.getAge());

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            int result=preparedStatement.executeUpdate(sql);
            if(result==1){
                System.out.println("Create operation performed");
            }
            else {
                System.out.println("Create operation not performed");
            }
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");

            e.printStackTrace();
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
        try(Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            )
        {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getEmail());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setLong(4,id);

            int rowAffected=preparedStatement.executeUpdate();
            if(rowAffected==1){
                System.out.println("Update operation performed");
            }
            else{
                System.out.println("Update operation not performed");
            }
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }

    public void deleteUser(Long id){
        String sql= """
                        DELETE from students WHERE id=?
                        """;
        try(Connection connection= DriverManager.getConnection(url,username,password);
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
        )
        {
            preparedStatement.setLong(1,id);
            int result=preparedStatement.executeUpdate();
            if(result==1){
                System.out.println("Delete operation performed");
            }
            else{
                System.out.println("Delete operation not performed");
            }
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");

            e.printStackTrace();
        }
    }

    public void getUserById(Long id){
        String sql= """
                        SELECT name,email,age FROM students
                        WHERE id=?
                        """;
        try(Connection connection= DriverManager.getConnection(url,username,password);

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ){
            preparedStatement.setLong(1,id);
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                if(resultSet.next()){
                    Student student=mapRow(resultSet);
                    System.out.println(student);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");

            e.printStackTrace();
        }
    }

    public void getStudent(){

        String sql= """
                        SELECT name,email,age FROM students
                        """;
        try(Connection connection= DriverManager.getConnection(url,username,password);

            PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ){
            try(ResultSet resultSet=preparedStatement.executeQuery()){
                while(resultSet.next()){
                    Student student=mapRow(resultSet);
                    System.out.println(student);
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");

            e.printStackTrace();
        }

    }

    public void completeCRUD(){
        try{
            Connection connection= DriverManager.getConnection(url,username,password);

            Statement statement=connection.createStatement();

            String sql="SELECT * from students WHERE id=4";
            boolean result=statement.execute(sql);
            // if result is true , we will get a resultSet
            // if result is false , we will get an integer (no of rows affected)
            if(result){
                ResultSet resultSet=statement.getResultSet();
            }
            else{
                Integer ans=statement.getUpdateCount();
            }

            connection.close();
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");

            e.printStackTrace();
        }
    }
    private Student mapRow(ResultSet resultSet) throws SQLException {
        Student student=new Student();
        student.setId(resultSet.getLong("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
