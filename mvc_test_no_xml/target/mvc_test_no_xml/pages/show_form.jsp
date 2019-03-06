<%--
  Created by IntelliJ IDEA.
  User: sbotnaru
  Date: 3/5/2019
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input form</title>
</head>
<body>
<center>

<%--
<form action="procesForm" method="get">
    <input type="text" name="studentName"
    placeholder="What's your name?">

    <input type="submit">
</form>
--%>

    <h2>Tap Student's name</h2>
    <form action="procesForm" method="post">
        First name:<br>
        <input type="text" name="studentName" >
        <br>
        Last name:<br>
        <input type="text" name="lastName" >
        <br><br>
        <input type="submit">
    </form>
    <a  href="/">Go back ->></a>
</center>
</body>
</html>
