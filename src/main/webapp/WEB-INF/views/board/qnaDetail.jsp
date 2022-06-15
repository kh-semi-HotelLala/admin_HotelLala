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
<link rel="stylesheet" 	href="${contextPath}/resources/css/board/qnaDetail-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<main class="container">

		<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
		
		<section id="content">
			
			
			<section id="board-QNA">
				<div id="content-top-title">Q&A</div>
				<div id="content-top-detial" class="bold">
					<p>상세 조회</p>
					<button class="fa-solid fa-x" id="deleteBtn"></button>
				</div>

				<div class="qna-area">
					<div class="Q">
						<table id="detail-table">
							<tr class="table-row">
								<td >${qna.category}</td>
								<td colspan="3" style="width:85% ;">${qna.title}</td>
							</tr>
							<tr class="table-row">
								<td>등록자</td>
								<td>${qna.memberName}</td>
								<td>작성일</td>
								<td>${qna.createDt}</td>
							</tr>
							<tr class="table-row">
								<td>휴대폰번호</td>
								<td>${qna.memberTel}</td>
								<td>이메일</td>
								<td>${qna.memberEmail}</td>
							</tr>
							<tr class="table-row content">
								<td colspan="4">
								${qna.content}
								</td>
							</tr>
							<tr class="table-row files">
								<td colspan="4" >
									<ul style="list-style:none;">
										<li>첨부파일1</a></li>
										<li>첨부파일2</a></li>
										<li>첨부파일3</a></li>
									</ul>
								</td>
							</tr>
						</table>
					</div>

					<div class="A">
						<h1 id="answerHeader">답변</h1>

						

						<form action="qna" method="POST" onsubmit="return answerValidate()">
							<input type="hidden" name="no" id="qnaNo" value="${qna.qnaNo}">
							<input type="hidden" name="adminNo" value="${adminLogin.adminNo}">
							<input type="hidden" name="type" value="insertAnswer">
							<textarea name="inputAnswer" id="answer" cols="30" rows="10">${qna.answerContent}</textarea>
							<button>답변하기</button>
						</form>
					</div>
			</section>


		</section>
	</main>

	<!-- jQuery Library 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- singup.js 연결 -->
    <script src="${contextPath}/resources/js/board/qna.js"></script>
</body>
</html>