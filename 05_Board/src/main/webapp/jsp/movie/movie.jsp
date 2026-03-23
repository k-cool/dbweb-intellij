<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/movie.js"></script>
</head>
<body>
<div style="display: flex; justify-content: center;">
    <form action="movie" method="post" enctype="multipart/form-data">

        <div class="movie-reg">
            <div>
                <div>Title</div>
                <div>
                    <input name="title">
                </div>
            </div>
            <div>
                <div>Actor</div>
                <div>
                    <input name="actor">
                </div>
            </div>
            <div>
                <div>File</div>
                <div>
                    <input type="file" name="file">
                </div>
            </div>
            <div>
                <div>Story</div>
                <div>
                    <textarea rows="5" cols="40" name="story"></textarea>
                </div>
            </div>
            <div>
                <div>
                    <button class="movie-btn">Add</button>
                </div>
            </div>
        </div>
    </form>
</div>

<hr>

<div style="width: 100%; display: flex; justify-content: center;">
    <div class="movie-container">
        <c:forEach var="movie" items="${movies}">
            <div class="movie-wrap">
                <div class="movie-img" onclick="location.href='detail-movie?no=${movie.no}'">
                    <img alt="" src="images/${movie.img}">
                </div>
                <div class="movie-title">${movie.title}</div>
                <div class="movie-actor">${movie.actor}</div>
                <div style="display: flex; align-items: center;">
                    <div>
                        <button class="movie-btn" onclick="deleteMovie('${movie.no}')">Delete</button>
                    </div>
                    <div>
                        <button class="movie-btn" onclick="location.href='movie-update?no=${movie.no}'">update(jsp)
                        </button>
                    </div>
                </div>

                <div style="display: flex; align-items: center;">
                    <div>
                        <button class="movie-btn" onclick="location.href='movie-edit?no=${movie.no}'">update(img,jsp)
                        </button>
                    </div>
                    <div>
                        <button class="movie-btn" onclick="deleteMovie('${movie.no}')">update(js)</button>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>


    <div>
        <button class="movie-btn pn"
                onclick="location.href='movie?p=${currentPage -1}'" ${currentPage == 1 ? "disabled": ""}>
            prev
        </button>

        <c:choose>
            <c:when test="${currentPage!= totalPage}">
                <button class="movie-btn pn"
                        onclick="location.href='movie?p=${currentPage +1}'" ${currentPage == totalPage? "disabled": ""}>
                    next
                </button>
            </c:when>
            <c:otherwise>
                <button class="movie-btn pn shake">next</button>
            </c:otherwise>
        </c:choose>


        <%--        <button class="movie-btn pn"--%>
        <%--                onclick="location.href='movie?p=${currentPage -1}'" ${currentPage == 1 ? "disabled": ""}>--%>
        <%--            prev--%>
        <%--        </button>--%>
        <%--        <button class="movie-btn pn"--%>
        <%--                onclick="location.href='movie?p=${currentPage +1}'" ${currentPage == totalPage? "disabled": ""}>next--%>
        <%--        </button>--%>
    </div>
</div>

<hr>

<div>
    <a href="movie">Begin</a>
    <c:forEach begin="1" end="${totalPage}" var="i">
        <a style="${i==currentPage ? "color: tomato;":""}" href="movie?p=${i}">[${i}]</a>
    </c:forEach>
    <a href="movie?p=${totalPage}">End</a>
</div>


</body>
</html>
