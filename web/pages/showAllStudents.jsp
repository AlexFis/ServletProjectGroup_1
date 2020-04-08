<%@ page import="java.util.List" %>
<%@ page import="model.Student" %><%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 24.02.2020
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student DataBase</title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/ServletProjectGroup_1_war_exploded/test?action=mainPage">Home</a></li>
                <li><a href="#">Students</a></li>
                <li><a href="#add">Add Student</a></li>
                <li><a href="#delete">Remove Student</a></li>
                <li><a href="#update">Update Student</a></li>
            </ul>
        </div>
    </div>
</nav>


<div>
    <% List<Student> studentList = (List<Student>) session.getAttribute("studentList"); %>
    <% for (Student student : studentList) { %>
    <input type="checkbox" name="students" id ="<%= "students" + student.getId() %>"
           value = "<%= student.getId() %>"
           value="<%= student.getName() %>">
    value="<%= student.getSalary() %>">
    <% } %>
</div>
</body>
</html>
