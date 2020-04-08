package Controller.processors;

import Controller.dao.WebLogicConnection;
import Controller.dao.WebLogicConnectionImpl;
import model.ProcessorResult;
import model.Student;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ProcessorViewAllStudents extends Processor {

    public ProcessorViewAllStudents() {
        action = "showAllStudents";
    }

    @Override
    public ProcessorResult getResult(HttpServletRequest request) {
        WebLogicConnection weblogicConnection = new WebLogicConnectionImpl();
        List<Student> studentList = weblogicConnection.showAllStudents();
        for (Student content : studentList) {
            System.out.println(content);
        }
        request.getSession().setAttribute("studentList",studentList);
        return new ProcessorResult("/main","/pages/showAllStudents.jsp",true);
    }
}
