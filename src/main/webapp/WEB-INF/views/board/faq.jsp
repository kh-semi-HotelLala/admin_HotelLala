 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Q&A</title>
<link rel="stylesheet"	href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/sideBar-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css//board/faq-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<main class="container">

		<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
		
		<section id="content">

			<section id="faq-content">
				<span id="content-top-title">* FAQ</span>
				
				<form id="select-filter">
					<div>
						<select name=""  id="">
							<option value="">제목</option>
							<option value="">내용</option>
							<option value="">제목+내용</option>
						</select>
						<input type="text" placeholder="검색"> 
						<button class="fa-solid fa-magnifying-glass"></button>
						</div>
				</form>

				
			<section id="faq-wrapper">
				<div class="tab-menu-area">
					<a href="" class="onChoice">전체</a>
					<a href="javascript: void(0);">예약</a>
					<a href="">결제</a>
					<a href="">시설 이용</a>
					<a href="">기타</a>
				</div>
			
				<div class="faq-content-area">
					<ul>
						<li>
							<div class="faq-list">
								<span class="on">카테고리</span><span class="tw">제목</span><span class="th">{작성일</span>
							</div>
						</li>
				</div>
			</section>
		</section>

		
		</section>
	</main>
</body>
</html>