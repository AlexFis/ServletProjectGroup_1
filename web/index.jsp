<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10.02.2020
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>

  <% for (int i = 0; i < 10; i++) {%>
    <p>Hello!</p>
  <% } %>

  Current time is:  <%= new java.util.Date() %>
  <%--Скриплети
  <% String s = request.getQueryString();
  out.println("Attached GET data: " + s);%>
  <br/>
  <%if (Math.random() < 5) {%>
  Have a <em>nice</em> day
  <%} else {%>
  Have a <em>lousy</em> day
  <%}%>--%>
  <%--Оголошення
  <%! int access = 0;%>
  Number of accesses:
  <%= ++access%>--%>

  <%--Директиви
  <%@ page import="java.util.*" %>
  <%@ include file="WEB-INF"%>--%>
  </body>
</html>
