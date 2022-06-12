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
	
	<c:when test="${ empty sessionScope.adminLogin}"><%-- 로그인 페이지 if 문 시작 --%>
	
	<main class="container" id="login-main">
		<section>
			<article class="login-box">
				<span class="login-logo"><img src="${contextPath}/resources/images/Logo.png"></span>
				<form action="login" method="POST" onsubmit="return loginValidate()"> 
					<div id="login-input">
						<span>아이디(이메일)</span>
						<input type="text" name="adminEmail" id="adminNo" placeholder="관리자 번호를 입력해주세요" autocomplete="off"><br>
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
		
		<div id="adminSignUp">
			<a href="${contextPath}/admin/signUp">관리자 가입</a>
		</div>

		<script src="${contextPath}/resources/js/main.js"></script>
	</main>

	</c:when><%-- 로그인 페이지 if 문 종료 --%>

	<c:otherwise><%-- 관리자 페이지 if 문 시작 --%>
		<main class="container">

			<jsp:include page="/WEB-INF/views/common/sideBar.jsp"/>
			<section class="content">
	
		  
	
	
				<section id="board-Notice">
				<a href="HotelLala/"></a>
				</section>
			</section>
		</main>
	</c:otherwise><%-- 관리자 페이지 if 문 시작 --%>
	
	</c:choose>
	</body>
	<%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>
	<c:if test="${ !empty sessionScope.message }">
		<script>
			alert("${message}");
			// EL 작성 시 scope를 지정하지 않으면
			// page -> request -> session -> application 순서로 검색하여
			// 일치하는 속성이 있으면 출력
		</script>
		<%-- message 1회 출력 후 session에서 제거 --%>
		<c:remove var="message" scope="session"/>
	</c:if>

	
</html>