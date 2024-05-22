<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Join</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>회원가입</h1>
<form id="registerForm" method="post" action="/register">
    <div>
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id">
    </div>
    <div>
        <label for="username">이름:</label>
        <input type="text" id="username" name="username">
    </div>
    <div>
        <label for="email">이메일:</label>
        <input type="text" id="email" name="email">
    </div>
    <div>
        <label for="password">비밀번호:</label>
        <input type="password" id="password" name="password">
    </div>
    <div>
        <label for="confirmPassword">비밀번호 확인:</label>
        <input type="password" id="confirmPassword" name="confirmPassword">
    </div>
    <div>
        <button type="submit">가입하기</button>
    </div>
</form>
<script>
    $(document).ready(function(){
        $("#registerForm").submit(function(event){
            event.preventDefault();

            var userData = {
                id: $("#id").val(),
                username: $("#username").val(),
                password: $("#password").val(),
                email: $("#email").val(),
            };

            $.ajax({
                type: "POST",
                url: "/user/register",
                contentType: "application/json",
                data: JSON.stringify(userData),
                dataType: "json",
                success: function(response){
                    // 회원가입 성공 처리
                },
                error: function(error){
                    // 오류 처리
                }
            });
        });
    });
</script>
</body>
</html>