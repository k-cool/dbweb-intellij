<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles/list.css"/>
    <script src="list.js" defer></script>
</head>
<body>

<div>
    <h1>Restaurant List</h1>
</div>

<form action="restaurant" method="post" enctype="multipart/form-data">
    <div class="input-container">
        <div class="input-name">
            <input type="text" placeholder="가게 이름" name="name"/>
        </div>
        <div class="input-place">
            <input type="text" placeholder="가게 주소" name="place"/>
        </div>
        <div class="input-img">
            <input type="file" placeholder="가게 이미지" name="img"/>
        </div>

        <button>Add</button>
    </div>
</form>


<div class="container">
    <c:forEach items="${restaurants}" var="r" varStatus="vs">
        <div class="r-row" onclick="updateItemName('${r.no}', '${r.name}')">
            <div class="r-item">${vs.count}</div>
            <div class="r-item">${r.name}</div>
            <div class="r-item">${r.place}</div>
            <img class="r-item" src="imgs/${r.img}" alt="restaurant"/>
            <div class="r-item">
                <button onclick="deleteItem(${r.no})">X</button>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>