<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>review page~!!~!</h2>

<div class="review-container">
    <div>
        <div class="review-title">
            Review Page <a href="review-add">[write]</a>
        </div>
        <c:forEach var="r" items="${reviews}">
            <div class="review-row" onclick="location.href='review-detail?no=${r.no}'">
                <div>
                    <span>${r.title}</span>
                </div>
                <div>${r.date}</div>
            </div>
        </c:forEach>
    </div>
</div>


<div>
    <c:forEach begin="1" end="${totalPage}" var="i">

        <a href="review?p=${i}">
                ${i}
        </a>
    </c:forEach>
</div>

</body>
</html>

