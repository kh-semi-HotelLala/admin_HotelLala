<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- session에 message 속성이 존재하는 경우 alert창으로 해당 내용을 출력 --%>

<c:if test="${ !empty sessionScope.message }">
	<script>
		alert("${message}");
		// EL 작성 시 scope를 지정하지 않으면
		// page -> request -> session -> application 순서로 검색하여
		// 일치하는 속성이 있으면 출력
	</script>
	<%-- message 1회 출력 후 session에서 제거 --%>
	<c:remove var="message" scope="session" />
</c:if>

<section id="side-bar">
            <div>
                <a href="${contextPath}">
                    <img src="${contextPath}/resources/images/LogoWhite.png" id="logo">
                </a>
            </div>
            <div>
                <div class="admin-info">
                    <!-- 프로필 이미지 ... 다시 고르기  -->
                    <div id="admin-img-area">
                        <a href="${contextPath}/info"><img src="${contextPath}/resources/images/user.png"></a>
                        <a href="${contextPath}/board/qna"><span id="alert">${adminLogin.qnaCount}</span></a>
                    </div>
                </div>
                <div class="admin-info">
                    <div id="admin-name">${adminLogin.adminName}</div>
                    <div id="admin-email">${adminLogin.adminEmail}</div>
                </div>
            </div>
            <div id="menu-bar">
                <div>Menu</div>
                <ul>
                    <li class="menu">
                        <strong id="reservation">예약</strong>
                        <ul>
                            <li class="board-list"><a href="${contextPath}/reservation/list">예약리스트</a></li>
                            <li class="board-list"><a href="${contextPath}/reservation/room">객실관리</a></li>
                            <li class="board-list"><a href="${contextPath}/reservation/refund">환불내역</a></li>
                        </ul>
                    </li>
                    
                    <li class="menu">
                    
                        <strong id="guest">고객</strong>
                        <ul>
                            <li class="board-list"><a href="${contextPath}/member/AllList" >고객 전체 조회</a></li>
                            <li class="board-list"><a href="${contextPath}/member/SearchOne" >고객 검색</a> </li>
                            <li class="board-list"><a href="${contextPath}/admin/signUp">관리자 가입</a> </li>
                        </ul>
                    </li>
                    <li class="menu">
                        <strong id="board">게시판</strong>
                        <ul>
                            <li class="board-list"><a href="${contextPath}/board/notice" >공지사항</a></li>
                            <li class="board-list"><a href="${contextPath}/board/qna" >QNA</a> </li>
                            <li class="board-list"><a href="${contextPath}/board/faq" >FAQ</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div>
                <a href="${contextPath}/logout" id="logout">로그아웃</a>
                <a href="hotelLala" id="goToHome">홈페이지</a>
            </div>
        </section>
  