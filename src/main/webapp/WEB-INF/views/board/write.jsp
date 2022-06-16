<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="${contextPath}/resources/images/wIcon.ico">
<title>게시글 작성</title>
<link rel="stylesheet"	href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/sideBar-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/board/wrtie-style.css">

<!-- <link rel="stylesheet" 	href="${contextPath}/resources/css/summernote/summernote-lite.css"> -->
<script src="https://kit.fontawesome.com/ea629e8085.js"
crossorigin="anonymous"></script>

<!-- ----------------------------- -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="${contextPath}/resources/js/summernote/summernote-lite.js"></script>
<script src="${contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${contextPath}/resources/css/summernote/summernote-lite.css">
<!-- ----------------------------- -->
</head>
<body>
<main class="container">

	<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
	
	<section id="content">
		
		
		<section id="board-QNA">
			<div id="content-top-title">Write</div>
			<div id="content-top-detial">*게시글</div>

		
			<div id="write-arer">
				<form action="" method="post" onsubmit="return inputValidate()">
					<div id="write-header">
						<select name="boardType" id="boardType">
							<option value="1">공지사항</option>
							<option value="2">FAQ</option>
						</select>
						<select name="category" id="category">
							<option value="1">기타</option>
							<option value="2">공지사항</option>
							<option value="3">결제</option>
							<option value="4">객실</option>
							<option value="5">시설</option>
							<option value="6">단체 이용</option>
						</select>
					<input type="text" placeholder="제목을 입력해" id="title" name="title">
					</div>

					<textarea name="editordata" id="summernote" cols="30" rows="10"></textarea>
					<input type="hidden" value="${adminLogin.adminNo}" name="adminNo">
					<button id="submitBtn">작성</button>
				</form>
			</div>
			${adminLogin.adminNo}

		</section>


	</section>
</main>



<script src="${contextPath}/resources/js/board/qna.js"></script>
<!-- <script src="${contextPath}/resources/js/summernote/lang/summernote-ko-KR.js"></script>
 --><script src="${contextPath}/resources/js/board/write.js"></script>
</body>
</html>