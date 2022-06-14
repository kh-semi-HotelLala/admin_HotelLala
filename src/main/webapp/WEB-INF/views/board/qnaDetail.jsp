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
				<div id="content-top-detial" class="bold">${qna.title}</div>

				<div class="qna-area">
					<div class="Q">
						<table id="detail-table">
							<tr class="table-row">
								<td>${qna.category}</td>
								<td colspan="3">제목입니다.</td>
							</tr>
							<tr class="table-row">
								<td>등록자</td>
								<td>김땡땡</td>
								<td>작성일</td>
								<td>2022-06-08</td>
							</tr>
							<tr class="table-row">
								<td>휴대폰번호</td>
								<td>${qna.memberTel}</td>
								<td>이메일</td>
								<td>${qna.memberEmail}</td>
							</tr>
							<tr class="table-row">
								<td colspan="4" style="height: 150px;">
								${qna}
								</td>
							</tr>
							<tr class="table-row">
								<td colspan="4" >
									<ul style="list-style:none;">
										<li><a href="">첨부파일1</a></li>
										<li><a href="">첨부파일2</a></li>
										<li><a href="">첨부파일3</a></li>
									</ul>
								</td>
							</tr>
						</table>
					</div>
			</section>


		</section>
	</main>
</body>
</html>