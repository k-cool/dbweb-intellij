<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="border: 1px solid black; width: 400px; margin: auto;">
    <thead>
    <tr style="width: 100%;">
        <td>순번</td>
        <td>이름</td>
        <td>나이</td>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="user" items="${userList}" varStatus="vs">
        <tr style="width: 100%;">
            <td>${vs.count}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
