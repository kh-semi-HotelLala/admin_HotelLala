<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
                    <div>6F</div>
                    <div>5F</div>
                    <div>4F</div>
                    <div>3F</div>
                    <div>2F</div>
                    <div>LOBBY</div>
                </div>
            </div>

            <div class="room">
                
                <div class="top">
                    <div class="room-info In">
                        <div>101</div>
                        <div>유저일 님</div>
                        <div>22.06.01~(1박)</div>
                        <div>
                            <a href="#">
                                <button class="reserve-detail">예약상세</button>
                            </a>
                        </div>
                    </div>
                    <div class="room-info In">
                        <div>102</div>
                        <div>유저일 님</div>
                        <div>22.06.01~(1박)</div>
                        <div>
                            <a href="#">
                                <button class="reserve-detail">예약상세</button>
                            </a>
                        </div>
                    </div>
                    <div class="room-info">
                        <div>103</div>
                        <div>예약가능</div>
                    </div>
                </div>

        </section>

    </main>

    <div id="modal">
        <div class="modal-window">
            <div class="modal-close">&times;</div>
            <div class="title">
                <div>예약 상세</div>
            </div>
            <div class="modal-content">
                <div>
                    <div>
                        <div>예약번호</div>
                        <div>01</div>
                    </div>
                    <div>
                        <div>예약자명</div>
                        <div>유저일</div>
                    </div>
                    <div>
                        <div>예약접수일</div>
                        <div>2022-06-01 00:00:00</div>
                    </div>
                    <div>
                        <div>입실일</div>
                        <div>2022.06.03(수) / 1박</div>
                    </div>
                    <div>
                        <div>인원</div>
                        <div>성인 : 2명</div>
                    </div>
                    <div>
                        <div>휴대폰번호</div>
                        <div>010-1234-1234</div>
                    </div>
                    <div>
                        <div>예약상태</div>
                        <div>예약완료</div>
                    </div>
                    <div>
                        <div>객실 요청 사항</div>
                        <div>헤어드라이기</div>
                    </div>
                </div>
            </div>
            <div class="modal-btn-area">
                <button id="modal-btn">확인</button>
            </div>
        </div>
    </div>


    <script src="${contextPath}/resources/js/room.js"></script>

</body>
</html>

            

            



    