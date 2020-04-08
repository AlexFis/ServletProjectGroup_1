package Controller.dao;

import model.Student;

import java.util.List;

public interface WebLogicConnection {
    void connectDB();
    void disconnectDB();
    List<Student> showAllStudents();
}
