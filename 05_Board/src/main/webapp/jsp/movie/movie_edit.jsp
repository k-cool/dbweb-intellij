<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Edit</h1>

<form action="movie-edit?no=${movie.no}" method="post" enctype="multipart/form-data">
    <div style="display: flex; justify-content: center;">

        <div class="movie-detail">
            <div>
                <div class="col-1">No.</div>
                <div class="col-2">
                    <input name="no" value="${movie.no}" readonly/>
                </div>
                <%-- <input name="no" value="${movie.no}" hidden/>--%>
            </div>
            <div>
                <div>
                    <img src="images/${movie.img}"/>
                    <input type="file" name="newImg"/>
                    <input name="oldImg" value="${movie.img}" hidden/>
                </div>
            </div>
            <div>
                <div class="col-1">Title.</div>
                <div class="col-2"><input name="title" value="${movie.title}"></div>

            </div>
            <div>
                <div class="col-1">Actor.</div>
                <div class="col-2"><input name="actor" value="${movie.actor}"></div>
            </div>

            <div>
                <div class="col-1">Story.</div>
                <div class="col-2"><textarea rows="5" cols="40" name="story">${movie.story}</textarea></div>
            </div>

            <div>
                <%-- <button class="movie-btn" name="no" value="${movie.no}" onclick="updateMovie()">Done</button>--%>
                <button class="movie-btn" onclick="updateMovie()">Done</button>
            </div>
        </div>

    </div>
</form>
</body>
</html>
