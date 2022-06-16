c:if<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>객실관리</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sideBar-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/reservation/room-style.css">
    
    <script src="https://kit.fontawesome.com/a7e904a504.js" crossorigin="anonymous"></script>
</head>
<body>

    <main class="container">
        
        <jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
        
        <section id="content">

            <div class="content-header">
                <div class="content-name">Room Manage</div> 
                <div class="content-detailname">- 객실관리</div>
            </div>

            <div class="floor-icon">
                <div>
                    <div class="floorBtn" id="sixthF">6F</div>
                    <div class="floorBtn" id="fifthF">5F</div>
                    <div class="floorBtn" id="forthF">4F</div>
                    <div class="floorBtn" id="thirdF">3F</div>
                    <div class="floorBtn floor-select" id="secondF">2F</div>
                    <div>LOBBY</div>
                </div>
            </div>

            <div class="room">
                <c:if test="${empty room}">
                    <div class="top">
                        <div class="room-info In">
                            <div>201</div>
                            <div>예약가능</div>
                            <div></div>
                        </div>
                        <div class="room-info In">
                            <div>202</div>
                            <div>예약가능</div>
                            <div></div>
                        </div>
                        <div class="room-info">
                            <div>203</div>
                            <div>예약가능</div>
                        </div>
                    </div>
                </c:if>
        </section>

    </main>

    <div class="modal">
        <div class="modal-window">
            <div class="modal-close">&times;</div>
            <div class="title">
                <div>예약 상세</div>
            </div>
            <div class="modal-content">
                <div>
                    <div>
                        <div>주문번호</div>
                        <div>${room}</div>
                    </div>
                    <div>
                        <div>예약자명</div>
                        <div></div>
                    </div>
                    <div>
                        <div>예약접수일</div>
                        <div></div>
                    </div>
                    <div>
                        <div>입실일</div>
                        <div></div>
                    </div>
                    <div>
                        <div>인원</div>
                        <div></div>
                    </div>
                    <div>
                        <div>휴대폰번호</div>
                        <div></div>
                    </div>
                    <div>
                    <!-- 질문사항 -->
                        <div>예약상태</div>
                        <div>예약완료</div>
                    </div>
                    <div>
                        <div>객실 요청 사항</div>
                        <div></div>
                    </div>
                </div>
            </div>
            <div class="modal-btn-area">
                <button id="modal-btn">확인</button>
            </div>
        </div>
    </div>


    <!-- jQuery 라이브러리 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- <script>const roomNo = ${roomNo}</script> -->
    <script src="${contextPath}/resources/js/reservation/room.js"></script>


</body>
</html>

            

            



    