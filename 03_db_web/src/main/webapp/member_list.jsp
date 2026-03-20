<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member List</title>
    <link rel="stylesheet" href="styles/style.css">
    <script src="js/member_list.js" defer></script>
</head>
<body>

<div class="member-container">
    <div class="member-row">
        <div class="member-item">Count</div>
        <%--        <div class="member-item">No</div>--%>
        <div class="member-item">Name</div>
        <div class="member-item">Age</div>
        <div class="member-item">Delete</div>
    </div>

    <c:forEach var="member" items="${memberList}" varStatus="vs">
        <div class="member-row">
            <div class="member-item">${vs.count}</div>
                <%--            <div class="member-item">${member.no}</div>--%>
            <div class="member-item">
                <span onclick="updateMemberName(${member.no}, '${member.name}')">${member.name}</span>
            </div>
            <div class="member-item">${member.age}</div>
            <div class="member-item">
                <button onclick="deleteMember(${member.no})">삭제</button>
            </div>

        </div>
    </c:forEach>
</div>


</body>
</html>
