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
<title>Q&A</title>
<link rel="stylesheet"	href="${contextPath}/resources/css/main-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/sideBar-style.css">
<link rel="stylesheet" 	href="${contextPath}/resources/css/board/qna-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<main class="container">

		<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
		
		<section id="content">
			
			
			<section id="board-QNA">
				<div id="content-top-title">Q&A</div>
				<div id="content-top-detial">*1:1문의</div>

				<form action="qna" method="get" id="fliter-search">
                    <div class="fliter-search">
						<input type="hidden" name="type" value="search">
                        <div>
                            <select name="answer" id="answer">
                                <option value="N">미답변</option>
                                <option value="Y">답변</option>
						    </select>

                            <select name="category" id="category">
                                <option value="0">모든</option>
                                <option value="1">기타</option>
                                <option value="3">결제</option>
                                <option value="4">객실</option>
                                <option value="5">시설이용</option>
                                <option value="6">단체 이용</option>
                            </select>
                        </div>
                            
                        <div class="search-area">
						     <button type="submit" id="search-btn">검색</button>
						</div>
                    </div>
                </form> 


				<div id="board-QNA-content">
					<table id="qna-table">
							<thead>
							<tr>
								<th>종류</th>
								<th>문의 제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th colspan="2">답변내역</th>
							</tr>
						</thead>
						
						<tbody id="tbody">
							<c:forEach var="qna" items="${qnaList}">
								<tr>
									<td>${qna.category}</td>
									<td><a href="qna?type=detail&no=${qna.qnaNo}">${qna.title}</a></td>
									<p style="width: 1px; background-color:#ddd;"></p>
									<td>${qna.memberName}</td>
									<td>${qna.createDt}</td>
									<td>${qna.answer}</td>
								</tr>
							</c:forEach>
						</tbody>    
					</table>
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