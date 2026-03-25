<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1> - my page - </h1>

<div class="info-wrap">
    <div class="info-row">
        <div>ID.</div>
        <div>${sessionScope.user.id}</div>
    </div>

    <div class="info-row">
        <div>PW.</div>
        <div>${sessionScope.user.pw}</div>
    </div>

    <div class="info-row">
        <div>NAME.</div>
        <div>${sessionScope.user.name}</div>
    </div>

    <div class="info-wrap">
        <button class="movie-btn">edit</button>
        <button class="movie-btn" onclick="deleteUser()">delete</button>
    </div>

    <div>
        <div class="confirm" style="display: none">
            데이터 다 날아가요 진짜 지워요?
            <br>
            <form action="user-delete" method="post">
                <input type="password" name="pw"/>
                <button class="movie-btn">confirm</button>
            </form>
        </div>
    </div>

</div>


<script>
    function deleteUser() {
        // const ok = confirm("Are you sure you want to delete this user?");
        //
        // if (!ok) return;
        //
        // location.href = "user-delete";

        document.querySelector('.confirm').style.display = 'block';
    }
</script>
</body>
</html>
