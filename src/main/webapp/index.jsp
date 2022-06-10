<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	
	
	<c:choose>
		<c:when test="${ empty sessionScope.adminLogin}">
			<link rel="stylesheet" href="${contextPath}/resources/css/login-style.css"> 
		</c:when>
		<c:otherwise>
			<link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
			<link rel="stylesheet" href="${contextPath}/resources/css/sideBar-style.css">
		</c:otherwise>
    </c:choose>

	<script src="https://kit.fontawesome.com/ea629e8085.js"	crossorigin="anonymous"></script>
    <title>HotelLala AdminPage</title>
    <script>
		const adminLogin = "${adminLogin}";
	</script>
    
</head>
<body>
  <body>


	<c:choose>
	
	<c:when test="${ empty sessionScope.adminLogin}">
	
	<main class="container" id="login-main">
		<section>
			<article class="login-box">
				<strong class="login-logo">Admin Login</strong>
				<form action="login" method="POST"> 
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

	</c:when>

	<c:otherwise>
		<main class="conainer">

			<section class="content">
	
		  
			<jsp:include page="/WEB-INF/views/common/sideBar.jsp"/>
	
	
				<section id="board-Notice">
				<a href="HotelLala/"></a>
				</section>
			</section>
		</main>
	</c:otherwise>
	
	</c:choose>
	
	</body>
</html>