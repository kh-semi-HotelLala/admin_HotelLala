<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${contextPath}/resources/css/login-style.css">
    <script src="https://kit.fontawesome.com/ea629e8085.js"	crossorigin="anonymous"></script>
    
    <title>비밀번호 찾기</title>
</head>
<body>
    <main class="container">
        <section>
        <article class="login-box" id="select-pw">
                 <form action="" id=""> 
                    <span class="login-logo"><img src="${contextPath}/resources/images/LogoWhite.png"></span>
                    <div class="input-name">
                        <span>이름</span>
                        <input type="text" placeholder="이름을 입력해주세요." autocomplete="off">
                    </div>
                    <div class="input-tel">
                        <span>전화번호</span>
                        <input type="text" placeholder="전화번호를 입력해주세요" autocomplete="off">
                    </div>
                    <div class="input-email">
                        <span>이메일</span>
                        <input type="text" placeholder="이메일을 입력해주세요." autocomplete="off">
                    </div>
                    <button type="email" id="select-pw-btn">임시비밀 번호 전송</button>
                </form>
        </article>
        </section>
    </main>
</body>
</html>