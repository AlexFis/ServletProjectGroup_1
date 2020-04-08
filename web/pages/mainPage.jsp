<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.02.2020
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="/pages/errorPage.jsp" %>
<html>
<head>
    <title>Main</title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="#">Home</a></li>
                <li><a href="/ServletProjectGroup_1_war_exploded/test?action=showAllStudents">Students</a></li>
                <li><a href="#add">Add Student</a></li>
                <li><a href="#delete">Remove Student</a></li>
                <li><a href="#update">Update Student</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="jumbotron">
        <l1 class="display-4">Hello, <%= session.getAttribute("userName") %>!</l1>
        <p class="lead"></p>
        <hr class="my-4">
        <p class="lead">
            <a class="btn btn-primary btn-lg"
               href="/ServletProjectGroup_1_war_exploded/test?action=logOut" role="button">Exit</a>
        </p>
    </div>
</div>
</body>
</html>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@page errorPage="/pages/errorPage.jsp" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Main</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div>Hello, <%= session.getAttribute("userName")%> </div>--%>
<%--<br/>--%>
<%--<div><a href="/ServletProjectGroup_1_war_exploded//test?action=logOut">Exit</a> </div>--%>
<%--<div>--%>
<%--    Menu:--%>
<%--    <ul>--%>
<%--        <li><a href="/ServletProjectGroup_1_war_exploded//test?action=showAllStudents">Students</a></li>--%>
<%--    </ul>--%>
<%--</div>--%>

<%--<div>--%>
<%--    Main part:--%>
<%--    <% String includedPage = (String) session.getAttribute("includedPage");%>--%>
<%--    <% if (includedPage != null) {%>--%>
<%--        <jsp:include page="<%= includedPage %>"/>--%>
<%--    <% } %>--%>
<%--</div>--%>

<%--</body>--%>
<%--</html>--%>
