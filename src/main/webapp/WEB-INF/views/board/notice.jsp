<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>notice</title>
<link rel="shortcut icon" href="${contextPath}/resources/images/wIcon.ico">

<link rel="stylesheet"	href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/sideBar-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css//board/notice-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
crossorigin="anonymous"></script>
</head>
<body>
<main class="container">

<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />

<section id="content">

	<section id="notice-content">

		<div id="content-top-title">notice</div>
		<div id="content-top-detial">*공지사항</div>
		
		
		<section id="notice-wrapper">
<!---------------------검색영역 시작--------------------------->
<div class="tab-menu-area">
	<p style="width: 1px; background-color:#ddd;"></p>
	<a href="notice" class="choice">전체</a>
	<p style="width: 1px; background-color:#ddd;"></p>
	<a href="notice?type=search&key=reservation">예약</a>
	<p style="width: 1px; background-color:#ddd;"></p>
	<a href="notice?type=search&key=payment">결제</a>
	<p style="width: 1px; background-color:#ddd;"></p>
	<a href="notice?type=search&key=facilities">시설 이용</a>
	<p style="width: 1px; background-color:#ddd;"></p>
	<a href="notice?type=search&key=group">단체</a>
	<p style="width: 1px; background-color:#ddd;"></p>
	<a href="notice?type=search&key=other">기타</a>
	<p style="width: 1px; background-color:#ddd;"></p>
</div>
<!---------------------검색-영역 끝-------------------------->


			<div class="notice-content-area">
				<ul class="notice-ul">
					<c:forEach var="notice" items="${noticeList}">
						<li class="notice-list">
							<div class="notice-header ">
								<span class="notice-category">${notice.category}</span>
								<span class="notice-title">${notice.title}</span>
								<span class="notice-createDate">${notice.createDate}</span>
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
	<!-- <script src="${contextPath}/resources/js/board/notice.js"></script> -->
</body>
</html>