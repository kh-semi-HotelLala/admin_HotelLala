<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>index</title>
<link rel="stylesheet"	href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/sideBar-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css//board/notice-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<main class="conainer">

		<section class="content">


			<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />

			<section id="board-notice">
				<span id="notice-top">* 공지사항</span>

				<form id="select-filter">
					<div>
						<select name="" id="">
							<option value="">제목</option>
							<option value="">내용</option>
							<option value="">제목+내용</option>
						</select> <input type="text" placeholder="검색">
						<button>검색</button>
					</div>
				</form>

				<div id="board-notice-content">
					<table id="table-top">
						<thead>
							<tr>
								<th>No.</th>
								<th>Title</th>
								<th>dateline</th>
							</tr>
						</thead>

						<tbody id="tbody">
							<tr>
								<td><input type="checkbox">1</td>
								<td><a href="">공지사항 제목 샘플 1</a></td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">2</td>
								<td>공지사항 제목 샘플 2</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">3</td>
								<td>공지사항 제목 샘플 3</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">4</td>
								<td>공지사항 제목 샘플 4</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">5</td>
								<td>공지사항 제목 샘플 5</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">6</td>
								<td>공지사항 제목 샘플 6</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">7</td>
								<td>공지사항 제목 샘플 7</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox">8</td>
								<td>공지사항 제목 샘플 8</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox" id="9"><label for="9">9</label></td>
								<td>공지사항 제목 샘플 9</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox" id="9"><label for="9">9</label></td>
								<td>공지사항 제목 샘플 9</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox" id="9"><label for="9">9</label></td>
								<td>공지사항 제목 샘플 9</td>
								<td>2022-05-14</td>
							</tr>
							<tr>
								<td><input type="checkbox" id="9"><label for="9">9</label></td>
								<td>공지사항 제목 샘플 9</td>
								<td>2022-05-14</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="list-btn">
					<button onclick="location.href='공지사항 작성.html'" id="">공지사항
						작성</button>
					<button>공지사항 수정</button>
					<button>공지사항 삭제</button>
				</div>
			</section>
		</section>
	</main>
</body>
</html>