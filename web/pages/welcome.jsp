<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 17.02.2020
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<div class="container">
    <form name="userForm" action="/ServletProjectGroup_1_war_exploded/test?action=mainPage" method="post">
        <div class="form-group">
            <label for="InputName">Enter the name: </label>
            <input type="name" name="userName" class="form-control" id="InputName" aria-describedby="nameHelp" placeholder="Type your name">
        </div>
        <button type="submit" class="btn btn-primary">Enter</button>
    </form>
</div>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Welcome</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <form name="userForm" action="/ServletProjectGroup_1_war_exploded//test?action=mainPage" method="post">--%>
<%--        <input type="text" name="userName" placeholder="Type your name" value="", size="20">--%>
<%--        Enter your name: <input type="submit" value="Enter">--%>
<%--    </form>--%>
<%--</body>--%>
<%--</html>--%>
