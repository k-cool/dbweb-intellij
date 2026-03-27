<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <%-- CSS --%>
    <link href="css/index.css" rel="stylesheet"/>
    <link href="css/movie.css" rel="stylesheet"/>
    <link href="css/review.css" rel="stylesheet"/>
</head>

<body>

<div class="login-area">
    <span style="color: tomato">${msg}</span>

    <jsp:include page="${loginPage}"/>
</div>


<div class="container">
    <div class="title">
        <a href="main"> Mz's place </a>
    </div>
    <div class="menu">
        <div>
            <a href="menu1">[Menu1]</a>
        </div>
        <div>
            <a href="movie">[Movie]</a>
        </div>
        <div>
            <a href="review">[Review]</a>
        </div>
    </div>
    <div class="content">
        <jsp:include page="${content}"/>
    </div>
</div>
</body>
</html>