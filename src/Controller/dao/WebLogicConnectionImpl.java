package Controller.dao;

import model.Student;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class WebLogicConnectionImpl implements WebLogicConnection {
    private DataSource dataSource;
    private Context context;
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public WebLogicConnectionImpl() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        hashtable.put(Context.PROVIDER_URL, "t3://localhost:7001");
        try {
            context = new InitialContext(hashtable);
            dataSource = (DataSource) context.lookup("MyJNDIName");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectDB() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnectDB() {
        try {
            connection.close();
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Student> showAllStudents() {
        connectDB();
        List<Student> studentList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from STUDENTS");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                studentList.add(parseStudent(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnectDB();
        return studentList;
    }

    private Student parseStudent(ResultSet resultSet) {
        Student student = null;
        int id;
        String name;
        float salary;
        try {
            id = resultSet.getInt("STUDENT_ID");
            name = resultSet.getString("STUDENT_NAME");
            salary = resultSet.getFloat("STUDENT_SALARY");
            student = new Student(id, name, salary);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
}
