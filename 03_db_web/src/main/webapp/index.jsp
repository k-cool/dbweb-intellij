<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<button onclick="location.href='member'">get all member</button>

<form action="member" method="POST">
    <input type="text" name="name"/>
    <input type="text" name="age"/>
    <button>add</button>
</form>

</body>
</html>