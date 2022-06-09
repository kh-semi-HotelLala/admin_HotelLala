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
    <title>HotelLala AdminPage</title>
</head>
<body>
  <body>
	    <main class="container">
	        <section>
		        <article class="login-box">
		            <strong class="login-logo">Admin Login</strong>
		                 <form action="admin" method="POST"> 
		                     <div id="login-input">
		                         <span>관리자번호</span>
		                         <input type="text" name="adminNo" id="adminNo" placeholder="관리자 번호를 입력해주세요" autocomplete="off"><br>
		                         <span>비밀번호</span>
		                         <input type="password" name="adminPw" id="adminPw" placeholder="비밀번호를 입력해주세요">
		                        </div>
		                        <div id="submit-btn">
		                    <button id="login-btn1">로그인</button>
		                    <button type="button" id="select-pw-btn2" onclick="location.href='findPw'">비밀번호 찾기</button>
		                    </div>   
		                </form>
		        </article>
	        </section>
	    </main>
	</body>
</html>