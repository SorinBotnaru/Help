<%--
  Created by IntelliJ IDEA.
  User: Sorin Botnaru
  Date: 3/6/2019
  Time: 08:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Spring MVC and List Example</h2>

<table>
    <c:forEach var="value" items="${lists}" >
    <tr> <td>${value}</td> </tr>
    </c:forEach>
</table>
</body>
</html>