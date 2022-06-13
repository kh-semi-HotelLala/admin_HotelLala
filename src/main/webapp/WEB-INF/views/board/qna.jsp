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
<link rel="stylesheet" 	href="${contextPath}/resources/css/board/qna-style.css">
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<main class="container">

		<jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
		
		<section id="content">
			
			
			<section id="board-QNA">
				<span id="content-top-title">* QNA</span>

				<form action="#" method="get" id="fliter-search">
                    <div class="fliter-search">
                        <div>
                            <select name="select">
                                <option value="">제목</option>
                                <option value="">내용</option>
                                <option value="">제목+내용</option>
                            </select>
                        </div>
                            
                        <div class="search-area">
                            <input type="search" id="search" name="search" autocomplete="off" placeholder="search">
                            <button type="submit" id="search-btn" >검색</button>
							<button type="button">미답변만 보기</button>
						</div>
                    </div>
                </form> 


				<div id="board-QNA-content">
					<table id="qna-table">
							<thead>
							<tr>
								<th colspan="2">종류</th>
								<th>문의 제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th colspan="2">답변내역</th>
							</tr>
						</thead>
						
						<tbody id="tbody">
							<c:forEach var="qna" items="${qnaList}">
								<tr>
									<td colspan="2">${qna.qnaNo}</td>
									<td>${qna.category}</td>
									<td><a href="qna?no=${qna.qnaNo}">${qna.title}</a></td>
									<td>${qna.memberName}</td>
									<td>2022-05-14</td>
									<td>${qna.answer}</td>
								</tr>
							</c:forEach>
						</tbody>    
						
					</table>
				</div>
			</section>


		</section>
	</main>
</body>
</html>