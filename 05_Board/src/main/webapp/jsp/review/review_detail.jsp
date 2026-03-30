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
            Review Detail Page
        </div>

        <div class="review-row">
            <div>
                <span>${review.no}</span>
            </div>
            <div>
                <span>${review.title}</span>
            </div>
            <div>
                <span>${review.txt}</span>
            </div>
            <div>Posted at ${review.date}</div>
        </div>
    </div>

    <div>
        <button class="movie-btn" onclick="deleteReview();">delete</button>
        <button class="movie-btn" onclick="location.href='review-update?no=${review.no}'">update</button>
    </div>
</div>

<script>
    function deleteReview() {
        const ok = confirm("Are you sure?");

        if (!ok) return;

        location.href = 'review-delete?no=${review.no}';

    }

</script>

</body>
</html>

