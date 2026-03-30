<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>review update page~!!~!</h2>

<div>
    <form action="review-update" method="post">

        <div class="review-wrap">
            <div>
                <div>
                    <div class="review-reg-col">Title</div>
                    <div class="review-reg-col2">
                        <input name="title" value="${review.title}">

                    </div>
                </div>
                <div>
                    <div class="review-reg-col">Text</div>
                    <div class="review-reg-col2">
                        <textarea name="txt" maxlength="200">${review.txt}</textarea>
                        <br> <span id="cntSpan">0</span> / 200
                    </div>

                    <div>Posted at: ${review.date}</div>
                </div>
                <div>
                    <input type="text" name="no" value="${review.no}" hidden/>
                    <input type="text" name="date" value="${review.date}" hidden/>
                    <button class="review-reg-btn">update</button>
                </div>
            </div>
        </div>
    </form>

</div>


<script type="text/javascript">
    const textarea = document.querySelector("textarea[name='txt']");
    const cntSpan = document.querySelector("#cntSpan");
    textarea.addEventListener('input', () => {
        const len = textarea.value.length;
        cntSpan.innerText = len;
    });

</script>

</body>
</html>

