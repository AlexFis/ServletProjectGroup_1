package Controller.dao;

import model.Student;
import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoConnectionImpl implements DaoConnection {

    private static DaoConnectionImpl daoConnection;
    private Connection connection;
    private Statement statement;
    private Driver driver;
    private ResultSet resultSet;

    private DaoConnectionImpl() {
        super();
    }

    public static DaoConnectionImpl getInstance() {
        if (daoConnection == null) {
            daoConnection = new DaoConnectionImpl();
        }
        return daoConnection;
    }

    @Override
    public void connect() {
        driver = new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","STUDENT","netcrackerfis13");
            if (!connection.isClosed()) {
                System.out.println("Connected successful!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            resultSet.close();
            statement.close();
            System.out.println("Connection was closed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> selectAllStudents() {
        connect();
        List<Student> studentList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM STUDENTS");
            while (resultSet.next()) {
                studentList.add(parseStud(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
        return studentList;
    }

    @Override
    public void createStudent(String name, float salary) {
        connect();
        try {
            statement = connection.prepareStatement("INSERT INTO STUDENTS (STUDENT_ID, STUDENT_NAME, STUDENT_SALARY)" +
                    "VALUES (NULL, ?, ?)");
            ((PreparedStatement)statement).setString(1, name);
            ((PreparedStatement)statement).setFloat(2, salary);
            ((PreparedStatement) statement).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }


    @Override
    public void updateStudent(int id, float sum) {
        connect();
        try {
            statement = connection.prepareStatement("UPDATE STUDENTS SET STUDENT_SALARY = ? WHERE STUDENT_ID = ?");
            ((PreparedStatement)statement).setFloat(1, sum);
            ((PreparedStatement)statement).setInt(2, id);
            ((PreparedStatement) statement).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    @Override
    public void deleteStudent(int id) {
        connect();
        try {
            statement = connection.prepareStatement("DELETE FROM STUDENTS WHERE STUDENT_ID = ?");
            ((PreparedStatement)statement).setInt(1, id);
            ((PreparedStatement) statement).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }


    private Student parseStud(ResultSet resultSet) {
        Student student = null;
        try {
            int id = resultSet.getInt("STUDENT_ID");
            String name = resultSet.getString("STUDENT_NAME");
            float salary = resultSet.getFloat("STUDENT_SALARY");
            student = new Student(id,name,salary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
