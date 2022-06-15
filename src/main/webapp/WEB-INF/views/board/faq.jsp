<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FAQ</title>
<link rel="shortcut icon" href="${contextPath}/resources/images/wIcon.ico">

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
			<a href="faq?type=search&key=reservation">예약</a>
			<p style="width: 1px; background-color:#ddd;"></p>
			<a href="faq?type=search&key=payment">결제</a>
			<p style="width: 1px; background-color:#ddd;"></p>
			<a href="faq?type=search&key=facilities">시설 이용</a>
			<p style="width: 1px; background-color:#ddd;"></p>
			<a href="faq?type=search&key=group">단체</a>
			<p style="width: 1px; background-color:#ddd;"></p>
			<a href="faq?type=search&key=other">기타</a>
			<p style="width: 1px; background-color:#ddd;"></p>
		</div>
	
		<div class="faq-content-area">
			<ul class="faq-ul">
				<c:forEach var="faq" items="${faqList}">
					<li class="faq-list">
						<div class="faq-header ">
							<span class="faq-category">${faq.category}</span>
							<p style="width:1px;background-color:#ddd;"></p>
							<span class="faq-title">${faq.title}</span>
							<p style="width:1px;background-color:#ddd;"></p>
							<span class="faq-createDate">${faq.createDate}</span>
						</div>
						<div class="faq-content">
							<textarea readonly>${faq.content}</textarea>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</section>
</section>


</section>
</main>
	<!-- jQuery Library 추가 -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!-- singup.js 연결 -->
	<script src="${contextPath}/resources/js/board/faq.js"></script>
</body>
</html>