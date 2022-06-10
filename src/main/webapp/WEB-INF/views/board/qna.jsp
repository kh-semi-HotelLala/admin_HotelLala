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
<link rel="stylesheet" 	href="${contextPath}/resources/css//board/qna-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<main class="conainer">

		<section class="content">


			<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />

			
			<section id="board-QNA">
				<span id="QNA-top">* QNA</span>

				<div id="select-filter">
					<select name=""  id="">
						<option value="">등급명</option>
						<option value="">고객명</option>
						<option value="">고객번호</option>
						<option value="">등급명</option>
					</select>
					<input type="text" placeholder="검색">
					<button>검색</button>
				</div>

				<div id="board-QNA-content">
					<table id="qna-table">
							<thead>
							<tr>
								<th>No.</th>
								<th>종류</th>
								<th>문의 제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th colspan="2">답변내역</th>
							</tr>
						</thead>
						
						<tbody id="tbody">
							<tr>
								<td>1</td>
								<td>결제</td>
								<td><a href="/admin/게시판/QNA 답변 작성.html">문의사항 제목 샘플 1</a></td>
								<td>작성자</td>
								<td>2022-05-14</td>
								<td>Y</td>
							</tr>
						</tbody>    
					</table>
				</div>
			
			</section>
		</section>
	</main>
</body>
</html>