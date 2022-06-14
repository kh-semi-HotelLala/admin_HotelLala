 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<div id="content-top-title">FAQ</div>
				<div id="content-top-detial">*자주 묻는 질문</div>
				
				
			<section id="faq-wrapper">
				<div class="tab-menu-area">
					<p style="width: 1px; background-color:#ddd;"></p>
					<a href="faq" class="choice">전체</a>
					<p style="width: 1px; background-color:#ddd;"></p>
					<a href="faq/reservation">예약</a>
					<p style="width: 1px; background-color:#ddd;"></p>
					<a href="faq/payment">결제</a>
					<p style="width: 1px; background-color:#ddd;"></p>
					<a href="">시설 이용</a>
					<p style="width: 1px; background-color:#ddd;"></p>
					<a href="faq/other">기타</a>
					<p style="width: 1px; background-color:#ddd;"></p>
				</div>
			
				<div class="faq-content-area">
					<ul class="faq-ul">

						<li class="faq-list">
							<div class="faq-header">
								<span class="faq-category">카테고리</span>
								<span class="faq-title">제목</span>
								<span class="faq-createDate">작성일</span>
							</div>
							<div class="faq-content">
								<p>라라호텔 객실 예약 대표 전화와 홈페이지 그리고 여행사를 통해 예약 가능합니다.</p>
							</div>
						</li>

						<li class="faq-list">
							<div class="faq-header">
								<span class="faq-category">카테고리</span>
								<span class="faq-title">제목</span>
								<span class="faq-createDate">작성일</span>
							</div>
							<div class="faq-content">
								<p >라라호텔 객실 예약 대표 전화와 홈페이지 그리고 여행사를 통해 예약 가능합니다.								</p>
							</div>
						</li>

					

						<li class="faq-list">
							<div class="faq-header">
								<span class="faq-category">카테고리</span>
								<span class="faq-title">제목</span>
								<span class="faq-createDate">작성일</span>
							</div>
							<div class="faq-content">
								<p >라라호텔 객실 예약 대표 전화와 홈페이지 그리고 여행사를 통해 예약 가능합니다.								</p>
							</div>
							<%-- 게시글번호를 저장하는 히든속성값(필요한가?) --%>
							<input type="hidden" name="boardNo" value="">
						</li>

					

					

					
					</ul>
				</div>
			</section>
		</section>

		
		</section>
	</main>
</body>
</html>