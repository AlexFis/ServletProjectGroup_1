package Controller.dao;

import model.Student;

import java.util.List;

public interface DaoConnection {
    void connect();
    void disconnect();
    List<Student> selectAllStudents();
    void createStudent(String name, float salary);
    void updateStudent(int id, float sum);
    void deleteStudent(int id);
}
