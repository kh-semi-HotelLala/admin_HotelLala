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
<script src="https://kit.fontawesome.com/ea629e8085.js"
crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/summernote/summernote-lite.css">

</head>
<body>
<main class="container">

<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />

<section id="content">
	<section id="notice-content">

		<div id="content-top-title">notice</div>
		<div id="content-top-detial">*공지사항</div>
		
		
		<section id="notice-wrapper">
			<div id="header">
				<span>${notice.category}</span>
				<span>${notice.title}</span>
			</div>
			<div class="createDt">${notice.createDate}</div>
			<div>
				<textarea readonly id="summernote" name="editordata">${notice.content}</textarea>
			</div>
		</section>
		<div id="deleteBtn"><a href="notice?type=delete&no=${param.no}">삭제</a></div>
	</section>
	

</section>
</main>
	
	 <script src="${contextPath}/resources/js/board/notice.js"></script> 
</body>
</html>