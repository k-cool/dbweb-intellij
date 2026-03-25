<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> - my page edit - </h1>

<form action="user-edit" method="post">
    <div class="info-wrap">
        <div class="info-row">
            <div>ID.</div>
            <%--   <div><input type="text" name="id" value="${sessionScope.user.id}"></div>--%>
            <div>${sessionScope.user.id}</div>
        </div>

        <div class="info-row">
            <div>PW.</div>
            <div><input type="text" name="pw" value="${sessionScope.user.pw}"></div>
        </div>

        <div class="info-row">
            <div>NAME.</div>
            <div><input type="text" name="name" value="${sessionScope.user.name}"></div>
        </div>

        <div>
            <button class="movie-btn" onclick="">done</button>

            <button class="movie-btn" type="button" onclick="history.back()">cancel</button>
        </div>
    </div>
</form>


</body>
</html>
