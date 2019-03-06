<%--
  Created by IntelliJ IDEA.
  User: sbotnaru
  Date: 3/5/2019
  Time: 1:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>



<head>
    <title>Proces Form</title>
    <style>
    table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
    }

    td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
    }

    tr:nth-child(even) {
    background-color: #dddddd;
    }
    </style>
</head>
<body>

<center>
<table>
    <tr>
        <th>Name</th>
    </tr>
    <c:if test="${not empty lists}">

        <ul>
            <c:forEach var="listValue" items="${lists}">
                <tr>
                    <td>${listValue}</td>
                </tr>

            </c:forEach>
        </ul>

    </c:if>
</table>

  <%--  <img src="${pageContext.request.contextPath}/pages/hello.gif">--%>
<a  href="/">Go back ->></a>

</center>
</body>
</html>
